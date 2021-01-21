package ManagerContact;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerContacts {
    List<Contacts> list = new ArrayList<>(readFromToFile());

    private static final String FILE_CONTACTS = "CTT.CSV";

    /**
     * Phương Thức Nhập Thông Tin
     *
     * @param input Nhập Dữ Liệu
     */
    public void ceartContacts(Scanner input) {
        System.out.println("Nhập Số Điện Thoại");
        String phone = input.nextLine();
        System.out.println("Nhập Tên Nhóm");
        String group = input.nextLine();
        System.out.println("Nhập Họ Và Tên");
        String fullName = input.nextLine();
        System.out.println("Nhập Giớ Tính");
        String gender = input.nextLine();
        System.out.println("Nhập Địa Chỉ");
        String address = input.nextLine();
        System.out.println("Nhập Ngày Tháng Năm Sinh");
        String dateOfBirth = input.nextLine();
        System.out.println("Nhập Email");
        String email = input.nextLine();
        Contacts contacts = new Contacts(phone, group, fullName, gender, address, dateOfBirth, email);
        list.add(contacts);
    }

    /**
     * Phương Thức Hiển Thị Thông Tin Theo Hàng Cột
     *
     * @param lists Danh Sách
     */
    public void showContacts(List<Contacts> lists) {
        System.out.printf("%-13s%-13s%-13s%-13s%-13s\n",
                "Phone Number", "Name Group", "FullName", "Gender", "Address");
        for (Contacts contact : lists) {
            System.out.printf("%-13s%-13s%-13s%-13s%-13s\n",
                    contact.getPhoneNumber(), contact.getGroupContact(),
                    contact.getFullName(), contact.getGender(), contact.getAddress());
        }
    }

    /**
     * Phương Thức Update Thông Tin
     *
     * @param input Nhập Liệu Đầu Vào
     */
    public void upDateContacts(Scanner input) {
        if (list.size() > 0) {
            System.out.println("Nhập Số Điện Thoại Bạn Muốn Cập Nhật");
            String phone = input.nextLine().trim();
            for (Contacts c : list) {
                if (c.getPhoneNumber().compareTo(phone) == 0) {
                    System.out.println("Nhập Tên Nhómg");
                    c.setGroupContact(input.nextLine());
                    System.out.println("Nhập Tên");
                    c.setFullName(input.nextLine());
                    System.out.println("Nhập Giới Tính");
                    c.setGender(input.nextLine());
                    System.out.println("Nhập Địa Chỉ");
                    c.setAddress(input.nextLine());
                }
            }
        } else {
            System.out.println("Danh Sách Rỗng");
        }
    }

    /**
     * Phương Thức Xoá 1 Số Điện Thoại Cho Trước
     *
     * @param input Nhập Dữ Liệu
     * @return Trả Về True là đã được xoá còn false là ngược lại
     */
    public boolean removeContacts(Scanner input) {
        System.out.println("Nhập Số Điện Thoại Của Bạn");
        String phone = input.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().compareTo(phone) == 0) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Phương Thức Tìm Kiếm Số Điện Thoại
     *
     * @param input Nhập Liệu
     */
    public void searchNumber(Scanner input) {
        System.out.println("Nhập Số Điện Thoại Cần Tìm");
        String phone = input.nextLine();
        List<Contacts> lists = new ArrayList<>();
        for (Contacts c : list) {
            if (c.getPhoneNumber().compareTo(phone) == 0) {
                lists.add(c);
            }
        }
        showContacts(lists);
    }

    /**
     * Phương Thức Ghi File
     *
     * @return True đã ghi file thành công false là ngược lại
     */
    public boolean writerFile() {
        File file = new File(FILE_CONTACTS);
        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter printWriter = new PrintWriter(fileWriter, true)) {
            for (Contacts c : list) {
                printWriter.println(c.getPhoneNumber());
                printWriter.println(c.getGroupContact());
                printWriter.println(c.getFullName());
                printWriter.println(c.getGender());
                printWriter.println(c.getAddress());
                printWriter.println(c.getDateOfBirth());
                printWriter.println(c.getEmail());
                printWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Phương Thức Đọc File
     *
     * @return Trả về một list
     */
    private List<Contacts> readFromToFile() {
        List<Contacts> list = new ArrayList<>();
        File file = new File(FILE_CONTACTS);
        try {
            file.createNewFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String phone = scanner.nextLine();
                String group = scanner.nextLine();
                String fullName = scanner.nextLine();
                String gender = scanner.nextLine();
                String address = scanner.nextLine();
                String dateOfBirth = scanner.nextLine();
                String email = scanner.nextLine();
                Contacts contacts = new Contacts(phone, group,
                        fullName, gender, address, dateOfBirth, email);
                list.add(contacts);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
