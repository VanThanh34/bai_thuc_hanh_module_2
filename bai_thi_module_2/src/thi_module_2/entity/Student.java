package thi_module_2.entity;

public class Student extends Class {
    private int studentId;
    private String studentName;
    private String studentDob;
    private String studentSex;
    private String studentPhone;


    public Student() {
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Student(int studentId, String studentSex, String studentDob, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentSex = studentSex;

    }

    public Student(String classID, int id,String sex , String dob,String name , String phone) {
        super(classID);
        this.studentId = id;
        this.studentSex = sex;

        this.studentDob = dob;
        this.studentName = name;
        this.studentPhone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentSex='" + studentName + '\'' +
                ", studentDob='" + studentDob + '\'' +
                ", studentName='" + studentSex + '\'' +
                '}';
    }
}
