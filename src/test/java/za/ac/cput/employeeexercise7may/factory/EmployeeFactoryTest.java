package za.ac.cput.employeeexercise7may.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeFactoryTest {

    @Test
    void a_buildEmployee() {
        Employee create = EmployeeFactory.buildEmployee(2233104, "Kim", "Bim");
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    void b_buildEmployeeFail(){
        Employee create = EmployeeFactory.buildEmployee(11023445, "", "Pool");
        assertNotNull(create);
        System.out.println(create);
    }
}