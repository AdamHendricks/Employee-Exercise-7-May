package za.ac.cput.employeeexercise7may.factory;

import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee(long employeeNumber, String firstname, String lastName){
        if(Helper.isNullOrEmpty(firstname, lastName)) return null;

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstname)
                .setLastName(lastName)
                .build();
    }
}
