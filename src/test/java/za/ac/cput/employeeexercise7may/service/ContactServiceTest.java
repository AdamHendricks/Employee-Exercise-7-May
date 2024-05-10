package za.ac.cput.employeeexercise7may.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    private static Contact contact1;

    @Test
    void e_getAll() {
        System.out.println(contactService.getAll());
    }

    @Test
    void a_create() {
        contact1 = ContactFactory.createContact("collette@gmail.com", "0652233178", "0652233178");
        Contact save = contactService.create(contact1);
        System.out.println(contact1);
    }

    @Test
    void b_read() {
        Contact read = contactService.read(contact1.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_findByMobile() {
        Contact findByMobile = contactService.findByMobile(contact1.getMobile());
        assertNotNull(findByMobile);
        System.out.println(findByMobile);
    }

    @Test
    void f_findByEmail(){
        Contact findByEmail = contactService.findByEmail(contact1.getEmail());
        assertNotNull(findByEmail);
        System.out.println(findByEmail);
    }

    @Test
    void d_update() {
        Contact updateContact = new Contact.Builder().copy(contact1).setWorkTelephone("021445679").build();
        Contact update = contactService.update(updateContact);
        assertNotNull(update);
        System.out.println(update);
    }
}