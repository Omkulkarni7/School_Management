package jdbc;

public class Enrollment {

	private int enrollmentId;
//    private int studentId;
//    private int courseId;
    private String studentName;
    private String courseName;
    private String teacherName;

    public Enrollment(int enrollmentId, String studentName, String courseName, String teacherName) {
        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", studentName=" + studentName + ", courseName="
				+ courseName + ", teacherName=" + teacherName + "]";
	}

	

	
    
    
}
