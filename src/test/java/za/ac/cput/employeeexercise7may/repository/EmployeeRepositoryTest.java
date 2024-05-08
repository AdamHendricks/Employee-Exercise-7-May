package za.ac.cput.employeeexercise7may.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.factory.EmployeeFactory;
import za.ac.cput.employeeexercise7may.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeService service;
    public static Employee employee1;

    @BeforeAll
    static void setUp(){
        employee1 = EmployeeFactory.buildEmployee(23041109, "John", "Cena");
        assertNotNull(employee1);
        System.out.println(employee1);
    }

    @Test
    void save(){
        Employee save = service.create(employee1);
        System.out.println(save);
    }

    @Test
    void findByFirstName() {
        Employee find = service.findByFirstName(employee1.getFirstName());
        assertNotNull(find);
        System.out.println(find);
    }
}