package jdbc;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;

    public Student(int studentId, String name, int age, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}

