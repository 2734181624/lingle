package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    public ResultSet rs = null;
    public Statement cs = null;
    public String url = "jdbc:mysql://localhost:3306/user?user=root&password=yj3366991018&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
    public Connection connection = null;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public ResultSet find(String str) {
        rs = null;
        try {
            cs = connection.createStatement();
            rs = cs.executeQuery(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdated(String str) {
        Statement s1 = null;
        try {
            s1 = connection.createStatement();
            s1.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
