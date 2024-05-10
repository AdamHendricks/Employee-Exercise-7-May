package za.ac.cput.employeeexercise7may.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity

public class Contact {
    @Id
    private String email;
    private String mobile;
    private String workTelephone;

    @OneToOne(mappedBy = "contact")
    private Employee employee;

    public Contact() {
    }

    public Contact (Builder builder){
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.workTelephone = builder.workTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public Employee getEmployee(){return employee;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(workTelephone, contact.workTelephone) && Objects.equals(employee, contact.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, workTelephone, employee);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", workTelephone='" + workTelephone + '}';
    }

    public static class Builder{
        private String email;
        private String mobile;
        private String workTelephone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setWorkTelephone(String workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }

        public Builder copy(Contact contact){
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.workTelephone = contact.workTelephone;
            return this;
        }

        public Contact build(){return new Contact(this);}
    }
}
