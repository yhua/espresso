package com.tw.espresso.dao;

import com.google.common.base.Throwables;
import org.springframework.jdbc.datasource.AbstractDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector extends AbstractDataSource {

    private String className;
    private String url;
    private String password;
    private String username;

    public DbConnector(String className, String url) {

        this.className = className;
        this.url = url;
    }

    public DbConnector(String className, String url, String password, String username) {
        this.className = className;
        this.url = url;
        this.password = password;
        this.username = username;
    }


    @Override
    public Connection getConnection() {
        try {
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

}
