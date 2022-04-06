package Crud.com.CRUD.Back.Controller;

import Crud.com.CRUD.Back.exception.ResourceNotFoundException;
import Crud.com.CRUD.Back.model.employee;
import Crud.com.CRUD.Back.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class employeeController {

    @Autowired
    private Crud.com.CRUD.Back.repository.employeeRepository EmployeeRepository;

    // get all employees
    @GetMapping("/employees")
    public List<employee> getAllEmployees(){
        return EmployeeRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/employees")
    public employee createEmployee(@RequestBody employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
        employee employee = EmployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api

    @PutMapping("/employees/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id, @RequestBody employee employeeDetails){
        employee employee = EmployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setSalaire(employeeDetails.getSalaire());

        employee updatedEmployee = EmployeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        employee employee = EmployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        EmployeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}