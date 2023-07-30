package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection;
        Properties props = new Properties();
        try {
            props.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(
                    props.getProperty("db_url"),
                    props.getProperty("user"),
                    props.getProperty("password"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }
}

