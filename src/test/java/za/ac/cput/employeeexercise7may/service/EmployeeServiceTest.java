package za.ac.cput.employeeexercise7may.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.factory.ContactFactory;
import za.ac.cput.employeeexercise7may.factory.EmployeeFactory;
import za.ac.cput.employeeexercise7may.repository.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    private static Employee employee1;
    private static Employee employee2;
    private static Contact contact1;
    private static Contact contact2;

    @BeforeAll
    static void setup(){
        contact1 = ContactFactory.createContact("jimslim@gmail.com", "0322256798", "0322256798");
        assertNotNull(contact1);
        System.out.println(contact1);
        contact2 = ContactFactory.createContact("jacky@gmail.com", "0322112798", "0322112798");
        assertNotNull(contact2);
        System.out.println(contact2);
        employee1 = EmployeeFactory.buildEmployee(1, "Slim", "Jim", contact1);
        assertNotNull(employee1);
        System.out.println(employee1);
        employee2 = EmployeeFactory.buildEmployeeGender(2, "Jacky", "Chan", contact2, "Male");
        assertNotNull(employee2);
        System.out.println(employee2);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }

    @Test
    void a_create(){
        Employee save = service.create(employee1);
        assertNotNull(save);
        System.out.println(save);
        Employee save2 = service.create(employee2);
        assertNotNull(save2);
        System.out.println(save2);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee1.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee1).setLastName("Kramer").build();
        Employee update = service.update(updated);
        assertNotNull(update);
        System.out.println(update);
    }
    @Test
    void e_delete(){
        service.delete(employee1.getEmployeeNumber());
        System.out.println("Employee deleted!");
    }
}