package jdbc;

public class Teacher {
    private int teacherId;
    private String name;
    private String subject;

    public Teacher(int teacherId, String name, String subject) {
        this.teacherId = teacherId;
        this.name = name;
        this.subject = subject;
    }

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}

