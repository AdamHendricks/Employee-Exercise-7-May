package za.ac.cput.employeeexercise7may.factory;

import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.domain.Gender;
import za.ac.cput.employeeexercise7may.util.Helper;

public class EmployeeFactory {

    private static Gender gender;
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

    public static Employee buildEmployeeGender(long employeeNumber, String firstname, String lastName, Contact contact, String maleOrFemale){
        if(Helper.isNullOrEmpty(firstname, lastName) || (!Helper.emailValidation(contact.getEmail())) || (!Helper.mobileAndWorkTelValidator(contact.getMobile(),
                contact.getWorkTelephone()))) return null;

        if(Helper.genderIsNullOrEmpty(maleOrFemale))return null;

        gender = new Gender.Builder().setMale(maleOrFemale).build();

        /*Contact contact1 = ContactFactory.createContact(email, mobile, workTelephone);*/

        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstname)
                .setLastName(lastName)
                .setContact(contact)
                .setGender(gender)
                .build();
    }
}

        //String email, String mobile, String workTelephone