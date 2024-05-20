package za.ac.cput.employeeexercise7may.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService implements IContactService{

    private ContactRepository repository;

    @Autowired
    ContactService(ContactRepository repository){this.repository=repository;}


    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String email) {
            repository.deleteContactByEmail(email);
    }

    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(String email) {
        return repository.findById(email).orElse(null);
    }

    public Contact findByMobile(String mobile){
        return repository.findAllByMobile(mobile);
    }

    public Contact findByEmail(String email){return repository.findByEmail(email);}

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }
}
