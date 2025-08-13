package thi_module_2.common;


import java.util.Scanner;

public class InputInteger {
        public static int inputInteger() {
            int choice;
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Vui lòng nhập số nguyên dương. Mời nhập lại: ");
                    continue;
                }catch (Exception e){
                    System.out.println("Lỗi không xác định!");
                    continue;
                }
                return choice;
            }
        }
    }

