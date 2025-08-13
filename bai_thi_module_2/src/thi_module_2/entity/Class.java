package thi_module_2.entity;

public class Class {
    private String classId;
    private String className;
    private String teacherId;

    public Class() {
    }

    public Class(String classId, String teacherId, String className) {
        this.classId = classId;
        this.teacherId = teacherId;
        this.className = className;
    }

    public Class(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
