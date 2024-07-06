package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public void enrollStudent(int studentId, int courseId) throws Exception {
        String query = "INSERT INTO Enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, studentId);
            pst.setInt(2, courseId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) throws Exception {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT e.enrollment_id, s.name AS student_name, c.course_name, t.name " +
                       "FROM Enrollments e " +
                       "JOIN Students s ON e.student_id = s.student_id " +
                       "JOIN Courses c ON e.course_id = c.course_id " +
                       "JOIN Teachers t ON c.teacher_id = t.teacher_id " +
                       "WHERE e.student_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(rs.getInt("enrollment_id"),
                                                        rs.getString("student_name"),
                                                        rs.getString("course_name"),
                                                        rs.getString("name"));
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }


}

