package za.ac.cput.employeeexercise7may.util;


import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public class Helper {

    //public static String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static boolean isNullOrEmpty(String firstName, String lastName){
        if(firstName.isEmpty() || lastName.isEmpty()) return true;
        else return false;
    }

    public static boolean genderIsNullOrEmpty(String gender){
        if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) return false;
        else return true;
    }

    /*public static boolean emailValidation(String email){
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }*/

    public static boolean emailValidation(String email){
        boolean isValid = EmailValidator.getInstance().isValid(email);
        return isValid;
    }

    public static boolean mobileAndWorkTelValidator(String mobile, String workTelephone){
        boolean isValid = false;
        if(mobile.length() == 10 && workTelephone.length() == 10) isValid = true;
        return isValid;
    }
}
