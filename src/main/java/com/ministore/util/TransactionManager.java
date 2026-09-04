package com.ministore.util;

import java.sql.Connection;
import java.sql.Savepoint;

public class TransactionManager {

    private final Connection connection;

    public TransactionManager(Connection connection) {
        this.connection = connection;
    }


    public void begin() throws Exception {
        connection.setAutoCommit(false);
    }


    public void commit() throws Exception {
        connection.commit();
        connection.setAutoCommit(true);
    }


    public void rollback() throws Exception {
        connection.rollback();
        connection.setAutoCommit(true);
    }


    public Savepoint createSavepoint(
            String name
    ) throws Exception {

        return connection.setSavepoint(name);
    }


    public void rollback(
            Savepoint savepoint
    ) throws Exception {

        connection.rollback(savepoint);
    }
    public void rollbackToSavepoint(
            Savepoint savepoint
    ) throws Exception {

        connection.rollback(savepoint);
    }
}