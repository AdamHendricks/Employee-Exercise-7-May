package za.ac.cput.employeeexercise7may.api;

import org.springframework.stereotype.Component;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.service.ContactService;
import za.ac.cput.employeeexercise7may.service.EmployeeService;

@Component
public class EmployeeContact {

    private EmployeeService employeeService;
    private ContactService contactService;

    EmployeeContact(EmployeeService employeeService, ContactService contactService){
        this.employeeService = employeeService;
        this.contactService = contactService;
    }

    public void testMethod(Long employeeId){
        employeeService.delete(employeeId);
    }

    //we use these services to communicate across each other for specific tasks

}
