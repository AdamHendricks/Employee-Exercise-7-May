package za.ac.cput.employeeexercise7may.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.factory.ContactFactory;
import za.ac.cput.employeeexercise7may.service.ContactService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactRepositoryTest {

    @Autowired
    private ContactService service;

    private static Contact contact1;

    @BeforeAll
    static void createContact(){
        contact1 = ContactFactory.createContact("jimmy@gmail.com", "0213345569", "0213345569");
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void a_saveContact(){
        Contact saved = service.create(contact1);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void b_findAllByMobile() {
        Contact findByMobile = service.findByMobile(contact1.getMobile());
        assertNotNull(findByMobile);
        System.out.println(findByMobile);
    }

    @Test
    void c_deleteByEmail(){
        service.delete(contact1.getEmail());
        System.out.println("Contact Deleted!");
    }


}