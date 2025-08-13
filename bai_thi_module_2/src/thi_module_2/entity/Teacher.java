package thi_module_2.entity;

public class Teacher extends Class {
    private String teacherName;
    private int teacherDob;
    private Boolean teacherSex;
    private int teacherPhone;

    public Teacher() {
    }

    public Teacher(String teacherId ,String teacherName, int teacherPhone, Boolean teacherSex, int teacherDob) {
        super(teacherId);
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        this.teacherSex = teacherSex;
        this.teacherDob = teacherDob;
    }
}
