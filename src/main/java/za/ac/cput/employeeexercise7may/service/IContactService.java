package za.ac.cput.employeeexercise7may.service;

import za.ac.cput.employeeexercise7may.domain.Contact;

import java.util.List;

public interface IContactService extends IService<Contact, String>{
    List<Contact> getAll();
    void delete(String email);
}
