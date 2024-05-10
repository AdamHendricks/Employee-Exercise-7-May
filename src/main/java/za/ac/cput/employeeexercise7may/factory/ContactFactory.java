package za.ac.cput.employeeexercise7may.factory;


import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;
import za.ac.cput.employeeexercise7may.util.Helper;

public class ContactFactory {
    public static Contact createContact(String email, String mobile, String workTelephone){
        if((!Helper.emailValidation(email)) || (!Helper.mobileAndWorkTelValidator(mobile, workTelephone))) return null;

        return new Contact.Builder().setEmail(email)
                .setMobile(mobile)
                .setWorkTelephone(workTelephone)
                .build();
    }
}
