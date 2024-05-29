package za.ac.cput.employeeexercise7may.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Gender implements ValueObject{
    private String gender;

    public Gender() {
    }

    public Gender(Builder builder){
        this.gender = builder.gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return Objects.equals(gender, gender.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "male='" + gender + '\'' +
                '}';
    }

    public static class Builder{
        private String gender;

        public Builder setMale(String male) {
            this.gender = male;
            return this;
        }

        public Builder copy(Gender gender){
            this.gender = gender.gender;
            return this;
        }

        public Gender build(){return new Gender(this);}
    }
}
