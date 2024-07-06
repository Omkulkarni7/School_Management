package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) throws Exception {
        String query = "INSERT INTO Students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getGrade());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents()throws Exception{
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student(rs.getInt("student_id"),
                        rs.getString("name"), rs.getInt("age"),
                        rs.getString("grade"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    
    public void updateStudent(Student student) throws Exception {
        String query = "UPDATE Students SET name = ?, age = ?, grade = ? WHERE student_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getGrade());
            pst.setInt(4, student.getStudentId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) throws Exception {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, studentId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

