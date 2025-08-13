package thi_module_2.repository;

import thi_module_2.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final static List<Student> students = new ArrayList<>();
    private static final String UrlFileStudent = "src/thi_module_2/data/Student.csv";

    @Override
    public List<Student> findAll() {
        File file = new File(UrlFileStudent);
        students.clear();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.trim().split(",");
                Student student = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy File!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc File!");
        }
        return new ArrayList<>(students);
    }

    @Override
    public void add(Student student) {
        if (student.getStudentId() <= 0) {
            System.out.println("ID sinh viên phải lớn hơn 0. Vui lòng nhập lại.");
            return;
        }

        List<Student> studentList = findAll();
        for (Student s : studentList) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("ID sinh viên đã tồn tại. Không thể thêm trùng ID.");
                return;
            }
        }

        students.add(student);
        File file = new File(UrlFileStudent);

        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(studentToString(student));
            bufferedWriter.newLine();
            System.out.println("Đã thêm sinh viên thành công!");
            System.out.println("============================");
        } catch (IOException e) {
            System.out.println("Lỗi ghi thông tin: " + e.getMessage());
        }
    }
    private String studentToString(Student student) {
        return student.getStudentId() + "," + student.getStudentName() + "," + student.getStudentDob() + "," + student.getStudentSex()+","+student.getStudentPhone();

    }
    @Override
    public boolean delete(int id) {
        List<Student> studentList = findAll();
        boolean isRemoved = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId() == id) {
                System.out.println("Thông tin sinh viên sẽ bị xóa:");
                System.out.println(studentList.get(i));
                studentList.remove(i);
                isRemoved = true;
                break;
            }
        }

        if (isRemoved) {
            overwriteFile(studentList);
            return true;
        }
        return false;
    }

    @Override
    public Student searchById(int id) {
        for (Student s : findAll()) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }
    private void overwriteFile(List<Student> studentList) {
        File file = new File(UrlFileStudent);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student student : studentList) {
                bufferedWriter.write(studentToString(student));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi đè File.");
        }
    }

    public List<Student> searchByName(String name) {
        List<Student> studentList = findAll();
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }
}
