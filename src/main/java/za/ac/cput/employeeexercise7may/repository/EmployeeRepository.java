package za.ac.cput.employeeexercise7may.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.employeeexercise7may.domain.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String firstName);
    void deleteById(Long employeeNumber);
}
