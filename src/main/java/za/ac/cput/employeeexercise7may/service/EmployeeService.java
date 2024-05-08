package za.ac.cput.employeeexercise7may.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository repository;

    @Autowired
    EmployeeService(EmployeeRepository repository){this.repository=repository;}

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee read(Long employeeNumber) {
        return repository.findById(employeeNumber).orElse(null);
    }

    public Employee findByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }
}
