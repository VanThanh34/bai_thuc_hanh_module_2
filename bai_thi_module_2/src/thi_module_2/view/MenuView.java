package thi_module_2.view;

import thi_module_2.common.InputInteger;
import thi_module_2.controller.StudentController;
import thi_module_2.entity.Student;
import thi_module_2.service.StudentService;

import java.util.Scanner;

public class MenuView {
    public static Scanner sc = new Scanner(System.in);
    private static final StudentService PRODUCT_SERVICE = new StudentService();
    public static void displayMenu() {
        while (true) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║              MENU HỆ THỐNG             ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1.  THÊM SINH VIÊN                     ║");
            System.out.println("║ 2.  XOÁ SINH VIÊN                      ║");
            System.out.println("║ 3.  HIỂN THỊ DANH SÁCH SINH VIÊN       ║");
            System.out.println("║ 4.  TÌM KIẾM SINH VIÊN                 ║");
            System.out.println("║ 5.  THOÁT HỆ THỐNG                     ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Lựa chọn của bạn: ");
            int choice = InputInteger.inputInteger();
            switch (choice) {
                case 1 -> StudentController.add();
                case 2 -> StudentController.delete();
                case 3 -> StudentController.display(PRODUCT_SERVICE.findAll());
                case 4 -> StudentController.searchByName();
                case 5 -> System.exit(5);
                default -> System.out.println("Mời nhập vào đúng số trong MENU!");
            }
        }
    }
    public static Student addStudent() {
        int id;
        String name;
        String dob;
        String sex;
        String phone;
        String classID;
        try {
            System.out.print("Nhập ID: ");
            id = InputInteger.inputInteger();
            name = nameStu();
            dob = dobStu();
            System.out.print("Nhập giới tính học sinh: ");
            sex = sc.nextLine();
            phone = phoneNumber();
            System.out.print("Nhập mã lớp học học sinh: ");
            classID = sc.nextLine();
        } catch (NumberFormatException e) {
            return null;
        }
        return new Student(classID, id, name, dob, sex, phone );
    }
    public static String phoneNumber() {
        System.out.print("Mời nhập số điện thoại của sinh viên: ");
        String phone = sc.nextLine();
        String validatePhone = "^(090|091)\\d{7}$";
        while (!phone.matches(validatePhone)) {
            System.out.print("Bạn nhập sai định dạng 090xxxxxxx hoặc 091xxxxxxx và chỉ dùng chữ sô. Vui lòng nhập lại: ");
            phone = sc.nextLine();
        }
        return phone;
    }
    public static String nameStu() {
        System.out.print("Mời nhập tên sinh viên: ");
        String name = sc.nextLine();
        String validateName = "[A-Za-z]{4,50}$";
        while (!name.matches(validateName)) {
            System.out.print("Tên sinh viên phải từ 4 đến 50 kí tự. Vui lòng nhập lại: ");
            name = sc.nextLine();
        }
        return name;
    }
    public static String dobStu() {
        System.out.print("Mời nhập ngày sinh của sinh viên: ");
        String dobStu = sc.nextLine();
        String validatePhone = "^\\d{2}/\\d{2}/\\d{4}$";
        while (!dobStu.matches(validatePhone)) {
            System.out.print("Bạn nhập sai định dạng dd/MM/yyyy và chỉ dùng chữ sô. Vui lòng nhập lại: ");
            dobStu = sc.nextLine();
        }
        return dobStu;
    }
    public static int deleteStudent() {
        System.out.print("Nhập ID cần xóa: ");
        return InputInteger.inputInteger();
    }
    public static String inputName() {
        System.out.print("Mời nhập vào tên sinh viên: ");
        return sc.nextLine();
    }
}
