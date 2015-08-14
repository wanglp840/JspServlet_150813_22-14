package servlet;

import entity.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wanglp on 2015/4/6.
 */
public class UserInfo extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if("add".equals(method)){
            this.add(request,response);
        }else if("del".equals(method)){
            this.del(request,response);
        }else if("edit".equals(method)){
            this.edit(request, response);
        }
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet resultSet = null;
        String courseName = request.getParameter("courseName");
        String userId = request.getParameter("userIdd");
        int userId2 = Integer.parseInt(userId);

        Connection connection = (Connection)getServletContext().getAttribute("connection");
        try {
            String sql = "INSERT INTO t_course(user_id,course_name) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,userId2);
            ps.setString(2,courseName);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }

        ArrayList<Course> list = new ArrayList<Course>();
        try {
            String sql = "SELECT * FROM t_course course WHERE course.`user_id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId2);
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
                list.add(course);
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        request.setAttribute("userId",userId2);
        request.setAttribute("courseList",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/info/user_info.jsp");
        dispatcher.forward(request,response);
    }
    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        int courseId2 = Integer.parseInt(courseId);

        String userId = request.getParameter("userIdd");
        int userId2 = Integer.parseInt(userId);

        String loginName = request.getParameter("userLoginName");
        request.setAttribute("loginName",loginName);

        ResultSet resultSet = null;
        Connection connection = (Connection)getServletContext().getAttribute("connection");
        try {
            String sql = "DELETE FROM t_course WHERE t_course.`id` =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,courseId2);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }

        ArrayList<Course> list = new ArrayList<Course>();
        try {
            String sql = "SELECT * FROM t_course course WHERE course.`user_id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId2);
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
                int courseId3 = resultSet.getInt(1);
                Course course = new Course();
                course.setCourseId(courseId3);
                course.setCourseName(uname);
                list.add(course);
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        request.setAttribute("userId",userId2);
        request.setAttribute("courseList",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/info/user_info.jsp");
        dispatcher.forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet resultSet = null;
        String courseName = request.getParameter("courseName");
        String courseId = request.getParameter("courseIdd2");
        int courseId2 = Integer.parseInt(courseId);
        String userId = request.getParameter("userId");
        int userId2 = Integer.parseInt(userId);

        Connection connection = (Connection)getServletContext().getAttribute("connection");
        try {
            String sql = "UPDATE t_course SET t_course.course_name=?  WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(2,courseId2);
            ps.setString(1,courseName);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }

        ArrayList<Course> list = new ArrayList<Course>();
        try {
            String sql = "SELECT * FROM t_course course WHERE course.`user_id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId2);
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
                int courseId3 = resultSet.getInt(1);
                Course course = new Course();
                course.setCourseId(courseId3);
                course.setCourseName(uname);
                list.add(course);
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        String loginName = request.getParameter("userLoginName");
        request.setAttribute("loginName",loginName);

        request.setAttribute("userId",userId2);
        request.setAttribute("userId",userId2);
        request.setAttribute("courseList",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/info/user_info.jsp");
        dispatcher.forward(request,response);
    }

}
