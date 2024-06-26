package za.ac.cput.employeeexercise7may.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    private long employeeNumber;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_contact",
        joinColumns =
                {@JoinColumn(name = "employeeNumber", referencedColumnName = "employeeNumber")},
    inverseJoinColumns =
            {@JoinColumn(name = "email", referencedColumnName = "email")})
    private Contact contact;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "email")
    private Contact contact;*/

    /*@OneToMany(mappedBy = "employee")
    private List<Contact> contact;*/

    public Employee() {
    }

    public Employee(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(contact, employee.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, firstName, lastName, contact);
    }

    /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return employeeNumber == employee.employeeNumber && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, firstName, lastName);
        }
    */

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                '}';
    }

    /*@Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }*/

    public static class Builder{
        private long employeeNumber;
        private String firstName;
        private String lastName;
        private Contact contact;

        public Builder setEmployeeNumber(long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy (Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.contact = employee.contact;
            return this;
        }

        public Employee build(){return new Employee(this);}
    }
}
