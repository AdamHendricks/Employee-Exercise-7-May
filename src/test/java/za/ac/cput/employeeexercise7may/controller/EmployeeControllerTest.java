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

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/exercise/employee";

    private static Employee employee;
    private static Contact contact;

    @BeforeAll
    static void setup(){
        contact = ContactFactory.createContact("steve@gmail.com", "0213340941", "0213340941");
        assertNotNull(contact);
        employee = EmployeeFactory.buildEmployee(310, "Steve", "Stevo", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee createdEmployee = response.getBody();
        assertEquals(createdEmployee.getEmployeeNumber(), employee.getEmployeeNumber());
        System.out.println("Saved data: " + employee);
    }

    @Test
    void b_read() {
        String url = BASE_URL +"/read/" + employee.getEmployeeNumber();
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee readEmployee = response.getBody();
        assertEquals(readEmployee.getEmployeeNumber(), employee.getEmployeeNumber());
        System.out.println("Read data: " + readEmployee);
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Employee updateEmployee = new Employee.Builder().copy(employee).setLastName("Score").build();
        assertNotNull(updateEmployee);
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updateEmployee, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        Employee responseEmployee = response.getBody();
        assertEquals(responseEmployee.getEmployeeNumber(), updateEmployee.getEmployeeNumber());
        System.out.println("Updated data: " + responseEmployee);
    }

    @Test
    void d_getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}