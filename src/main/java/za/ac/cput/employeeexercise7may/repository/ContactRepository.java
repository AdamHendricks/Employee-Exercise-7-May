package za.ac.cput.employeeexercise7may.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.employeeexercise7may.domain.Contact;
import za.ac.cput.employeeexercise7may.domain.Employee;

@Repository
public interface ContactRepository extends JpaRepository <Contact, String>{
    Contact findAllByMobile(String mobile);

    @Query("select u from Contact u where u.email = ?1")
    Contact findByEmail(String email);
}
