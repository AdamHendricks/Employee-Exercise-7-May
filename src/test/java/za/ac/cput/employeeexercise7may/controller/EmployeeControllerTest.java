package za.ac.cput.employeeexercise7may.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.factory.ContactFactory;
import za.ac.cput.employeeexercise7may.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    String BASE_URL = "http://localhost:8080/exercise/employee";

    private static Employee employee;
    private static Contact contact;

    @BeforeAll
    static void setup(){
        contact = ContactFactory.createContact("bob@gmail.com", "0622230978", "0622230978");
        assertNotNull(contact);
        employee = EmployeeFactory.buildEmployeeGender(1, "Bob", "Builder", contact, "Male");
        assertNotNull(employee);
        System.out.println(contact);
    }

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee created = response.getBody();
        assertEquals(employee.getEmployeeNumber(), created.getEmployeeNumber());
        System.out.println("Data created");
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read";
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee read = response.getBody();
        assertEquals(employee.getEmployeeNumber(), read.getEmployeeNumber());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Employee newEmployee = new Employee.Builder().copy(employee).setLastName("Buzz").build();
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, newEmployee, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee employeeUpdated = response.getBody();
        assertEquals(newEmployee.getEmployeeNumber(), employeeUpdated.getEmployeeNumber());
        System.out.println("Data updated: " + employeeUpdated);
    }

    @Test
    void d_getall() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeNumber();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeNumber();
        restTemplate.delete(url);
        System.out.println("Deleted!");
    }
}