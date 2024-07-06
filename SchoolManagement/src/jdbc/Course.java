package jdbc;

public class Course {
    private int courseId;
    private String courseName;
    private int teacherId;

    public Course(int courseId, String courseName, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
    }

    public Course(String courseName, int teacherId) {
        this.courseName = courseName;
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}

