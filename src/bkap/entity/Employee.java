package bkap.entity;

import bkap.checkValidate.Check;

import java.util.List;
import java.util.Scanner;

public class Employee {
//    a. Có các trường sau:
//             employeeId: String
// employeeName: String
// age int
// rate float (Hệ số lương)
// salary float (lương)
// employeeStatus boolean
//    b. 2 constructor: contructor default và contructor khởi tạo tất cả thông tin nhân
//            viên
//    c. Các phương thức getter/setter
//    d. Phương thức inputData cho phép nhập thông tin nhân viên (trừ salary)
//    e. Phương thức displayData cho phép hiển thị thông tin nhân viên
//    f. Phương thức calSalary cho phép tính lương tất cả nhân viên theo công thức
//    salary = rate*1.300.000
    private String employeeId;
    private String employeeName;
    private int age;
    private float rate;
    private float salary;
    private  boolean employeeStatus;
    public Employee(){

    }
    public Employee(String employeeId, String employeeName, int age, float rate, float salary, boolean employeeStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.rate = rate;
        this.salary = salary;
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
    public void inputData(List<Employee> list){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhập ID : ");
            this.employeeId = sc.nextLine();
            if (Check.checkId(this.employeeId,list)){
                System.err.println("Id đã tồn tại , vui lòng nhập id khác");
            }else {
                break;
            }
        }while (true);
        System.out.print("Nhập tên : ");
        this.employeeName = sc.nextLine();
        System.out.print("Nhập tuổi : ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập hệ số lương : ");
        this.rate = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập trạng thái : ");
        this.employeeStatus = Boolean.parseBoolean(sc.nextLine());
    }
    public void displayData(){
        System.out.println("------------------------------------------------------");
        System.out.printf("ID : %-20s\n",this.employeeId);
        System.out.printf("Name : %-30s\n",this.employeeName);
        System.out.printf("Age : %-10d\n",this.age);
        System.out.printf("Rate : %-10.1f\n",this.rate);
        System.out.printf("Salary : %-20.1f\n",this.salary);
        if (this.employeeStatus){
            System.out.printf("Hoạt động");
        }else {
            System.out.printf("Không hoạt động");
        }
        System.out.println();

        System.out.println("------------------------------------------------------");
    }
    public void calSalary(){
        this.salary = this.rate*1300000;
    }
}
