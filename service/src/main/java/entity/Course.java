package entity;

/**
 * Created by Administrator on 2015/4/6.
 */
public class Course {
    private int courseId;
    private int userId;
    private String courseName;
    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
