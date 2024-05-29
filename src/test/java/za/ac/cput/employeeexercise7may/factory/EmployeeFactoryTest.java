package za.ac.cput.employeeexercise7may.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeFactoryTest {
    private static Contact contact;

    @BeforeAll
    static void createContact(){
        contact = ContactFactory.createContact("kim@gmail.com", "0651129870", "0651129870");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void a_buildEmployee() {
        Employee create = EmployeeFactory.buildEmployee(2233104, "Kim", "Bim", contact);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    void b_buildEmployeeFail(){
        Employee create = EmployeeFactory.buildEmployee(11023445, "", "Pool", contact);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    void c_buildEmployeeWithGender(){
        Employee create = EmployeeFactory.buildEmployeeGender(11023445, "Kim", "Pool", contact, "male");
        assertNotNull(create);
        System.out.println(create);
    }
}