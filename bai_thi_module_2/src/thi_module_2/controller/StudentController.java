package thi_module_2.controller;

import thi_module_2.entity.Student;

import thi_module_2.service.StudentService;
import thi_module_2.view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static StudentService service = new StudentService();
    private final static Scanner sc = new Scanner(System.in);
    private static List<Student> lastSearchResult = new ArrayList<>();
    public static void add() {
        Student student = MenuView.addStudent();
        if (student != null) {
            service.add(student);
        } else {
            System.out.println("❌ Không thể thêm học sinh vì dữ liệu không hợp lệ.");
        }
    }

    public static void delete() {
        int idDelete = MenuView.deleteStudent();
        Student studentToDelete = service.searchById(idDelete);
        if (studentToDelete == null) {
            System.out.println("Không tìm thấy sinh viên có ID: " + idDelete);
            return;
        }
        System.out.println("Thông tin sinh viên sẽ bị xóa: ");
        System.out.println(studentToDelete);
        System.out.println("Bạn có muốn xóa sinh viên này không? (Y/N): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            boolean success = service.delete(idDelete);
            if (success) {
                System.out.println("✅ Đã xóa sinh viên thành công.");
            }

        } else {
            System.out.println("❎ Hủy xóa sinh viên.");
        }
    }

    public static void display(List<Student> students) {
        System.out.println("════════════ DANH SÁCH SINH VIÊN ════════════");
        if (students == null || students.isEmpty()) {
            System.out.println("⚠ Danh sách sinh viên trống.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
    public static void searchByName() {
        String name = MenuView.inputName();
        List<Student> students = service.searchByName(name);
        if (students.isEmpty()) {
            System.out.println("============================");
            System.out.println("Không tìm thấy sinh viên nào.");
            System.out.println("============================");
        } else {
            System.out.println("======== Kết quả tìm kiếm ========");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
