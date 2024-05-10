package za.ac.cput.employeeexercise7may.factory;

import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee(long employeeNumber, String firstname, String lastName, Contact contact){
        if(Helper.isNullOrEmpty(firstname, lastName) || (!Helper.emailValidation(contact.getEmail())) || (!Helper.mobileAndWorkTelValidator(contact.getMobile(),
                contact.getWorkTelephone()))) return null;

        /*Contact contact1 = ContactFactory.createContact(email, mobile, workTelephone);*/

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstname)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }
}

        //String email, String mobile, String workTelephone