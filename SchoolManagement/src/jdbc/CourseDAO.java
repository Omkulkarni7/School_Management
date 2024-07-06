package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public void addCourse(Course course) throws Exception {
        String query = "INSERT INTO Courses (course_name, teacher_id) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, course.getCourseName());
            pst.setInt(2, course.getTeacherId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Courses";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Course course = new Course(rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("teacher_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    
}
