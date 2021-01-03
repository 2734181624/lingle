package com.servlet;

import com.dao.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/indexInsertHomeServlet")
public class indexInsertHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("username");
        String password = request.getParameter("password");
        int flag = 0;
        if (id == "" || password == "") {
            flag = 0;
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('密码或者账号为空');");
            writer.write("window.location.href = '/Online_Account_Book_war_exploded/insert.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        if (id != "" && password != "") {
            String sqlst = "select * from user where id='" + id + "' and code='" + password + "'";
            Database database = new Database();
            ResultSet rs = database.find(sqlst);
            try {
                rs.last();
                if (rs.getRow() == 0) {
                    flag = 0;//账号或者密码错误
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('账号或者密码错误！');");
                    writer.write("window.location.href = '/Online_Account_Book_war_exploded/insert.jsp'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                } else {
                    flag = 1;//账号密码正确
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('登录成功！');");
                    writer.write("window.location.href = '/Online_Account_Book_war_exploded/index.html'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            response.sendRedirect("/Online_Account_Book_war_exploded/index.html");
        } else {
            request.getRequestDispatcher("/Online_Account_Book_war_exploded/insert.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
