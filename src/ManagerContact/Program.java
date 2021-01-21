package ManagerContact;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManagerContacts manager = new ManagerContacts();
        int choice;
        do {
            System.out.println("1. Xem Danh Sách");
            System.out.println("2. Thêm Mới");
            System.out.println("3. Cập Nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm Kiếm");
            System.out.println("6. Ghi Vào File");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    manager.showContacts(manager.list);
                    break;
                case 2:
                    manager.ceartContacts(input);
                    break;
                case 3:
                    manager.upDateContacts(input);
                    break;
                case 4:
                   boolean result = manager.removeContacts(input);
                   if (result)
                       System.out.println("Xoá Thành Công");
                   else System.out.println("Xoá Thất Bại");
                    break;
                case 5:
                    manager.searchNumber(input);
                    break;
                case 6:
                  boolean result1 = manager.writerFile();
                  if (result1) System.out.println("Ghi File Thành Công");
                  else System.out.println("Ghi File Thất Bại");
                    break;
            }
        }while (true);
    }
}
