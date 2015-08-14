package servlet;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: wanglp
 * @Time: 2015/4/1.
 */

public class Register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = (String)request.getParameter("username");
        String passWord = (String)request.getParameter("password");

        Connection connection = (Connection)getServletContext().getAttribute("connection");
        try {
            String sql ="INSERT INTO t_user(user_name,user_password) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passWord);
            ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }


        request.setAttribute("str","恭喜 注册成功");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/register/register.jsp");
        dispatcher.forward(request,response);
    }
}
