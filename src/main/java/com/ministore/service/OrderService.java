package com.ministore.service;

import com.ministore.dao.OrderDAO;
import com.ministore.dao.ProductDAO;
import com.ministore.model.Order;
import com.ministore.config.DatabaseConnection;
import com.ministore.dao.OrderDetailDAO;
import com.ministore.dao.ProductDAO;
import com.ministore.model.OrderDetail;
import com.ministore.model.Product;
import com.ministore.util.TransactionManager;
import com.ministore.service.discount.DiscountStrategy;
import com.ministore.service.discount.NoDiscountStrategy;


import java.util.List;
import java.math.BigDecimal;
import java.sql.Connection;

public class OrderService {
    private final OrderDAO orderDAO ;
    private final OrderDetailDAO orderDetailDAO;
    private final ProductDAO productDAO;
    private final DiscountStrategy discountStrategy;
    public OrderService() {
        this.orderDAO = new OrderDAO();
        this.orderDetailDAO = new OrderDetailDAO();
        this.productDAO = new ProductDAO();
        this.discountStrategy = new NoDiscountStrategy();
    }

    public List<Order> findAll() {
        return orderDAO.findAll();
    }
    public Order findById(int id) {
        return orderDAO.findById(id);
    }

    public void updateOrderStatus(int orderId, int status) {
        orderDAO.updateStatus(orderId, status);
    }
    public int insert(Order order) {
        return orderDAO.insert(order);
    }
    public int createOrder(
            Order order,
            int[] productIds,
            int[] quantities
    ) throws Exception {

        if (productIds == null ||
                quantities == null ||
                productIds.length == 0 ||
                productIds.length != quantities.length) {

            throw new IllegalArgumentException(
                    "Danh sách sản phẩm không hợp lệ!"
            );
        }

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            TransactionManager transaction =
                    new TransactionManager(connection);

            try {

                transaction.begin();

                BigDecimal totalPrice = BigDecimal.ZERO;


                for (int i = 0;
                     i < productIds.length;
                     i++) {

                    int productId =
                            productIds[i];

                    int quantity =
                            quantities[i];

                    if (quantity <= 0) {
                        throw new IllegalArgumentException(
                                "Số lượng phải lớn hơn 0!"
                        );
                    }

                    Product product = productDAO.findById(
                                    productId,
                                    connection
                            );
                    if (product == null) {
                        throw new IllegalArgumentException(
                                "Không tìm thấy sản phẩm: "
                                        + productId
                        );
                    }

                    BigDecimal subtotal =
                            product.getPrice()
                                    .multiply(
                                            BigDecimal.valueOf(
                                                    quantity
                                            )
                                    );

                    totalPrice =
                            totalPrice.add(subtotal);
                }

                BigDecimal discount = discountStrategy.calculateDiscount(
                                totalPrice
                        );

                BigDecimal finalPrice = totalPrice.subtract(discount);

                order.setTotalPrice(finalPrice);
//              order.setTotalPrice(totalPrice);


                int orderId = orderDAO.insert(
                                order,
                                connection
                        );

                if (orderId <= 0) {
                    throw new Exception(
                            "Không thể tạo đơn hàng!"
                    );
                }


                for (int i = 0;
                     i < productIds.length;
                     i++) {

                    int productId =
                            productIds[i];

                    int quantity =
                            quantities[i];

                    Product product = productDAO.findById(
                                    productId,
                                    connection
                            );

                    OrderDetail detail =
                            new OrderDetail();

                    detail.setOrderId(orderId);
                    detail.setProductId(productId);
                    detail.setQuantity(quantity);
                    detail.setPrice(product.getPrice());

                    boolean detailSuccess = orderDetailDAO.insert(
                                    detail,
                                    connection
                            );

                    if (!detailSuccess) {
                        throw new Exception(
                                "Không thể thêm Order Detail!"
                        );
                    }

                    boolean stockSuccess = productDAO.updateStock(
                                    productId,
                                    quantity,
                                    connection
                            );

                    if (!stockSuccess) {
                        throw new Exception(
                                "Không đủ tồn kho cho sản phẩm: "
                                        + product.getName()
                        );
                    }
                }


                transaction.commit();

                return orderId;

            } catch (Exception e) {


                transaction.rollback();

                throw e;
            }
        }
    }
}