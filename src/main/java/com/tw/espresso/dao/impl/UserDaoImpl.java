package com.tw.espresso.dao.impl;

import com.tw.espresso.dao.DbConnector;
import com.tw.espresso.dao.UserDao;
import com.tw.espresso.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

@Component
public class UserDaoImpl implements UserDao {

    private static final String CREATE_USER = "insert into user (name, password, email, age) values ('%s', '%s', '%s', %s)";

    @Autowired
    private DbConnector connector;

    @Override
    public void createUser(User user) {
        try (Statement statement = connector.getConnection().createStatement()) {
            String sql = format(CREATE_USER, user.getName(), user.getPassword(), user.getEmail(), user.getAge());
            statement.executeUpdate(sql);
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
