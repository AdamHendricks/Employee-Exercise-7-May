package za.ac.cput.employeeexercise7may.util;

public class Helper {
    public static boolean isNullOrEmpty(String firstName, String lastName){
        if(firstName.isEmpty() || lastName.isEmpty()) return true;
        else return false;
    }
}
