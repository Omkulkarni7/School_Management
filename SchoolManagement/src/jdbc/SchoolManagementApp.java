package jdbc;

import java.util.List;
import java.util.Scanner;

public class SchoolManagementApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		TeacherDAO teacherDAO = new TeacherDAO();
		CourseDAO courseDAO = new CourseDAO();
		EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

		while (true) {
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Add Teacher");
			System.out.println("4. View Teachers");
			System.out.println("5. Add Course");
			System.out.println("6. View Courses");
			System.out.println("7. Enroll Student in Course");
            System.out.println("8. View Student Enrollments");
            System.out.println("9. Update Student");
            System.out.println("10. Delete Student");
            System.out.println("11. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter student name: ");
				String studentName = scanner.nextLine();
				System.out.print("Enter student age: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter student grade: ");
				String grade = scanner.nextLine();
				Student student = new Student(studentName, age, grade);
				studentDAO.addStudent(student);
				System.out.println("Student added successfully!");
				break;

			case 2:
				List<Student> students = studentDAO.getAllStudents();
				for (Student s : students) {
					System.out.println(s);
				}
				break;

			case 3:
				System.out.print("Enter teacher name: ");
				String teacherName = scanner.nextLine();
				System.out.print("Enter teacher subject: ");
				String subject = scanner.nextLine();
				Teacher teacher = new Teacher(teacherName, subject);
				teacherDAO.addTeacher(teacher);
				System.out.println("Teacher added successfully!");
				break;

			case 4:
				List<Teacher> teachers = teacherDAO.getAllTeachers();
				for (Teacher t : teachers) {
					System.out.println(t);
				}
				break;

			case 5:
				System.out.print("Enter course name: ");
				String courseName = scanner.nextLine();
				System.out.print("Enter teacher ID: ");
				int teacherId = scanner.nextInt();
				scanner.nextLine();
				Course course = new Course(courseName, teacherId);
				courseDAO.addCourse(course);
				System.out.println("Course added successfully!");
				break;

			case 6:
				List<Course> courses = courseDAO.getAllCourses();
				for (Course c : courses) {
					System.out.println(c);
				}
				break;

			case 7:
				System.out.print("Enter student ID: ");
				int studentId = scanner.nextInt();
				System.out.print("Enter course ID: ");
				int courseId = scanner.nextInt();
				enrollmentDAO.enrollStudent(studentId, courseId);
				System.out.println("Student enrolled in course successfully!");
				break;

			case 8:
				System.out.print("Enter student ID: ");
				int studentIdToView = scanner.nextInt();
				List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByStudent(studentIdToView);
				for (Enrollment enrollment : enrollments) {
					System.out.println(enrollment);
				}
				break;
			case 9:
			    System.out.print("Enter student ID to update: ");
			    int studentIdToUpdate = scanner.nextInt();
			    scanner.nextLine(); // Consume newline
			    System.out.print("Enter new name: ");
			    String newName = scanner.nextLine();
			    System.out.print("Enter new age: ");
			    int newAge = scanner.nextInt();
			    scanner.nextLine();
			    System.out.print("Enter new grade: ");
			    String newGrade = scanner.nextLine();
			    Student updatedStudent = new Student(studentIdToUpdate, newName, newAge, newGrade);
			    studentDAO.updateStudent(updatedStudent);
			    System.out.println("Student updated successfully!");
			    break;

			case 10:
			    System.out.print("Enter student ID to delete: ");
			    int studentIdToDelete = scanner.nextInt();
			    studentDAO.deleteStudent(studentIdToDelete);
			    System.out.println("Student deleted successfully!");
			    break;
			case 11:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid option, please try again.");
			}
		}
	}
}
