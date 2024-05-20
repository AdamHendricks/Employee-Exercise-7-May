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
import za.ac.cput.employeeexercise7may.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/exercise/contact";

    private static Contact contact;

    @BeforeAll
    static void setUp(){
        contact = ContactFactory.createContact("lz@gmail.com", "0223897674", "0223897674");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact contactSaved = postResponse.getBody();
        assertEquals(contact.getEmail(), contactSaved.getEmail());
        System.out.println("Saved data: " + contactSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + contact.getEmail();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url, Contact.class);
        assertEquals(contact.getEmail(), response.getBody().getEmail());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL +"/update";
        Contact newContact = new Contact.Builder().copy(contact).setMobile("0614459114").build();
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, newContact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact contactUpdated = postResponse.getBody();
        assertEquals(newContact.getEmail(), contactUpdated.getEmail());
        System.out.println("Updated data: " + contactUpdated);
    }

    @Test
    void d_getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: " );
        System.out.println(response);
        System.out.println(response.getBody());
    }
}