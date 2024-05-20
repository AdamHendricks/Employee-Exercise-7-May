package za.ac.cput.employeeexercise7may.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){return service.create(employee);}

    @GetMapping("/read/{employeenumber}")
    public Employee read(@PathVariable Long employeenumber){return service.read(employeenumber);}

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){return service.update(employee);}

    @GetMapping("/getall")
    public List<Employee> getall(){return service.getAll();}
}
