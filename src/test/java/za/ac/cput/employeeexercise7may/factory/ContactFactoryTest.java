package za.ac.cput.employeeexercise7may.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactFactoryTest {

    @Test
    void createContact() {
        Contact contact = ContactFactory.createContact("Jimmy@gmail.com", "0623347890", "0212246571");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void failCreateContact(){
        Contact contact2 = ContactFactory.createContact("gmail", "0212246571", "0212246571");
        assertNotNull(contact2);
        System.out.println(contact2);
    }
}