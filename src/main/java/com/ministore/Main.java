package com.ministore;

import com.ministore.controller.*;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import com.ministore.filter.AuthFilter;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();
        String webappPath = new File("src/main/webapp").getAbsolutePath();
        System.out.println("Webapp path: " + webappPath);

        Context context = tomcat.addWebapp("", webappPath);

        Tomcat.addServlet(
                context,
                "loginServlet",
                new LoginServlet()
        );

        context.addServletMappingDecoded(
                "/login",
                "loginServlet"
        );
        FilterDef filterDef = new FilterDef();
        filterDef.setFilterName("authFilter");
        filterDef.setFilter(new AuthFilter());

        context.addFilterDef(filterDef);

        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName("authFilter");

        filterMap.addURLPattern("/home");
        filterMap.addURLPattern("/products");
        filterMap.addURLPattern("/categories");
        filterMap.addURLPattern("/orders");

        context.addFilterMap(filterMap);
        Tomcat.addServlet(
                context,
                "logoutServlet",
                new LogoutServlet()
        );

        context.addServletMappingDecoded(
                "/logout",
                "logoutServlet"
        );

        Tomcat.addServlet(
                context,
                "homeServlet",
                new HomeServlet()
        );
        context.addServletMappingDecoded(
                "/home",
                "homeServlet"
        );

        Tomcat.addServlet(
                context,
                "productServlet",
                new ProductServlet()
        );
        context.addServletMappingDecoded(
                "/products",
                "productServlet"
        );

        Tomcat.addServlet(
                context,
                "categoryServlet",
                new CategoryServlet()
        );

        context.addServletMappingDecoded(
                "/categories",
                "categoryServlet"
        );

        Tomcat.addServlet(
                context,
                "orderServlet",
                new OrderServlet()
        );

        context.addServletMappingDecoded(
                "/orders",
                "orderServlet"
        );



        tomcat.start();

        System.out.println(
                "Mini Store running at http://localhost:8080"
        );

        tomcat.getServer().await();
    }
}