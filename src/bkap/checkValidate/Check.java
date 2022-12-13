package bkap.checkValidate;

import bkap.entity.Employee;

import java.util.List;

public class Check {
    public static Boolean checkId(String id, List<Employee> list){
        for (Employee employee : list) {
            if(employee.getEmployeeId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
