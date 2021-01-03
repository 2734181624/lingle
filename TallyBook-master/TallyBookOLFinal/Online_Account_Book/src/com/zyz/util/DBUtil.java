package com.zyz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    final private static String driver = "com.mysql.cj.jdbc.Driver";
    final private static String url = "jdbc:mysql://localhost:3306/account_book?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
    final private static String user = "root";
    final private static String password = "yj3366991018";

    //    @Test
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(DBUtil.getConnection());
    }
}
