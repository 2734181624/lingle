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

@WebServlet(urlPatterns = "/indexAddUserServlet")
public class indexAddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int flag = 0;
        String name = request.getParameter("username");
        String id = request.getParameter("userid");
        String phonenumber = request.getParameter("userphonenumber");
        String password = request.getParameter("username");
        if (name == "" || id == "" || phonenumber == "" || password == "") {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('注册不能为空');");
            writer.write("window.location.href = '/Online_Account_Book_war_exploded/insert.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        if (name != "" && id != "" && phonenumber != "" && password != "") {
            String sqlst = "select * from user where phonenumber='" + phonenumber + "'";
            Database database = new Database();
            ResultSet rs = database.find(sqlst);
            try {
                if (rs.isAfterLast()!=rs.isBeforeFirst()) {                   //该电话号码已经注册
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('该电话号码已经注册！');");
                    writer.write("window.location.href = '/Online_Account_Book_war_exploded/insert.jsp'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                } else {                                    //该电话号码未注册
                    String sqlinsertuser = "insert into user values('" + id + "','" + name + "',+'" + phonenumber + "','" + password + "')";
                    database.executeUpdated(sqlinsertuser);
                    flag = 1;
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('注册成功！');");
                    writer.write("window.location.href = '/Online_Account_Book_war_exploded/insert.jsp'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            response.sendRedirect("/Online_Account_Book_war_exploded/insert.jsp");
        } else {
            request.getRequestDispatcher("/Online_Account_Book_war_exploded/insert.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
