package za.ac.cput.employeeexercise7may.service;

import za.ac.cput.employeeexercise7may.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService <Employee, Long>{
    List<Employee> getAll();
}
