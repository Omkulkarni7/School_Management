package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public void addTeacher(Teacher teacher) throws Exception {
        String query = "INSERT INTO Teachers (name, subject) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, teacher.getName());
            pst.setString(2, teacher.getSubject());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() throws Exception {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM Teachers";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacher_id"),
                        rs.getString("name"), rs.getString("subject"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

}

