package za.ac.cput.employeeexercise7may.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){return service.create(contact);}

    @GetMapping("/read/{email}")
    public Contact contact(@PathVariable String email){return service.read(email);}

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){return service.update(contact);}

    @GetMapping("/getall")
    public List<Contact> getall(){return service.getAll();}

}
