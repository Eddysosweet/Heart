import bkap.entity.Employee;
import bkap.entity.SortBySalary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

//        1. Nhập thông tin cho n nhân viên
//        2. Tính lương tất cả nhân viên
//
//        Tài liệu thực hành Java Core
//
//        Page | 7
//        3. Hiển thị thông tin tất cả nhân viên
//        4. Sắp xếp nhân viên theo lương tăng dần
//        5. Tìm kiếm nhân viên theo tên nhân viên
//        6. Cập nhật trạng thái nhân viên theo mã nhân viên
//        7. Thoát
        int choice;
        boolean check = true;
        do {
            System.out.println("============== MENU ================");
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Tính lương tất cả nhân viên");
            System.out.println("3. Hiển thị thông tin tất cả nhân viên");
            System.out.println("4. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("5. Tìm kiếm nhân viên theo lương nhân viên");
            System.out.println("6. Cập nhật trạng thái nhân viên theo mã nhân viên ");
            System.out.println("7. Thoát");
            System.out.println("Mời bạn nhập lựa chọn");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception exp) {
                System.err.println("Vui lòng nhập 1 số từ 1 - 7");
                continue;
            }
            switch (choice) {
                case 1:
                    int n;
                    System.out.println("Nhập số lượng nhân viên muốn thêm : ");
                    do {
                       try {
                           n = Integer.parseInt(sc.nextLine());
                       }catch (Exception exp){
                           System.err.println("Số bạn vừa nhập không hợp lệ , vui lòng nhập 1 cố nguyên >0");
                           continue;
                       }
                       if (n<=0){
                           System.err.println("Số bạn vừa nhập không hợp lệ , vui lòng nhập 1 cố nguyên >0");
                           continue;
                       }
                       break;
                    }while (true);
                    for (int i = 0; i < n ; i++) {
                        System.out.println("----------------------------------------------------------------------");
                        System.out.printf("Nhập Employee thứ %d \n",i+1);
                        Employee newEmployee = new Employee();
                        newEmployee.inputData(list);
                        list.add(newEmployee);
                    }
                    break;
                case 2:
                    for (Employee employee: list
                         ) {
                        employee.calSalary();
                    }
                    break;
                case 3:
                    for (Employee employee : list) {
                        employee.displayData();
                    }
                    break;
                case 4:
                    Collections.sort(list,new SortBySalary());
                    for (Employee employee : list) {
                        employee.displayData();
                    }
                    break;
                case 5:
                    System.out.println("Mời bạn nhập tên cần tìm kiếm ");
                    String strName = sc.nextLine();
                    boolean isTrue = false;
                    for (Employee employee:list
                         ) {
                        if (employee.getEmployeeName().contains(strName)) {
                            employee.displayData();
                            isTrue = true;
                        }
                    }
                    if (!isTrue) {
                        System.err.println("Không tìm thấy");
                    }
                    break;
                case 6:
                    System.out.println("Nhập id muốn cập nhật trạng thái");
                    String id = sc.nextLine();
                    boolean rs = false;
                    for (Employee employee:list
                    ) {
                        if (employee.getEmployeeId().equals(id)) {
                            employee.setEmployeeStatus(!employee.isEmployeeStatus());
                            rs = true;
                        }
                    }
                    if (rs) {
                        System.out.println("Chuyển trạng thái thành công !");
                    }else {
                        System.err.println("Thất bại , id không tồn tại");
                    }
                    break;
                case 7:
                    check=false;
                    break;
            }
        } while (check);
    }
}