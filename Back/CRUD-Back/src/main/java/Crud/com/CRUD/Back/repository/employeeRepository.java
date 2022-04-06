package Crud.com.CRUD.Back.repository;

import Crud.com.CRUD.Back.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@Repository
@CrossOrigin("http://localhost:4200")
public interface employeeRepository extends JpaRepository<employee,Long> {
}
