package servlet;

/**
 * @Author: wanglp
 * @Time: 2015/4/1.
 */


import entity.Course;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = (String)request.getParameter("username");
        String passWord = (String)request.getParameter("password");

        ResultSet resultSet = null;
        Connection connection = (Connection)getServletContext().getAttribute("connection");
        try {
            String sql = "SELECT * FROM t_user u WHERE u.`user_name`=? AND u.`user_password`= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passWord);
            Boolean result = ps.execute();
            if (result!=false){
                resultSet=ps.getResultSet();
            }
        }catch (SQLException e){
           System.out.println(e.getErrorCode());;
        }

        PrintWriter out = response.getWriter();
        String userName2 = null;
        int userId = 0;
        try {
            while (resultSet.next()){
                userName2 = resultSet.getString(2);
                userId = resultSet.getInt(1);
            }
        }catch (SQLException e){
            System.out.print(e);
        }


        ArrayList<Course> list = new ArrayList<Course>();
        try {
            String sql = "SELECT * FROM t_course course WHERE course.`user_id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            Boolean result = ps.execute();
            if (result!=false){
                resultSet=ps.getResultSet();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
        try {
            while (resultSet.next()){
                String uname= resultSet.getString(3);
                int courseId = resultSet.getInt(1);

                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(uname);
                course.setUserId(userId);
                list.add(course);
            }
        }catch (SQLException e){
            System.out.print(e);
        }



        request.setAttribute("loginName",userName);
        request.setAttribute("userId",userId);
        request.setAttribute("courseList",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/info/user_info.jsp");
        dispatcher.forward(request,response);
    }
}
