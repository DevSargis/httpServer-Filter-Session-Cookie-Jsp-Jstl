package com.onlinsestore.servletsonlinestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL="db.url";
    private static final String USER_KEY="db.user";
    private static final String PASSWORD_KEY="db.password";

    private ConnectionManager(){}

    public static Connection get(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
