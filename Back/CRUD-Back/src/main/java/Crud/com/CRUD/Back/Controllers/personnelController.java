package Crud.com.CRUD.Back.Controllers;


import Crud.com.CRUD.Back.entites.personnel;
import Crud.com.CRUD.Back.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class personnelController {
    @Autowired
    private Crud.com.CRUD.Back.repositories.personnelRepository PersonnelRepository;
    // get all employees
    @GetMapping("/personnels")
    public List<personnel> getAllPersonnel(){
        return PersonnelRepository.findAll();
    }
    // create employee rest api
    @PostMapping("/personnels")
    public personnel createpersonnel(@RequestBody personnel Personnel) {
        return PersonnelRepository.save(Personnel);
    }

    // get employee by id rest api
    @GetMapping("/personnels/{id}")
    public ResponseEntity<personnel> getPersonnelById(@PathVariable Long id) {
        personnel personnel = PersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personnel n'exicte pas :" + id));
        return ResponseEntity.ok(personnel);
    }

    // update peronnel rest api

    @PutMapping("/personnels/{id}")
    public ResponseEntity<personnel> updatePersonnel(@PathVariable Long id, @RequestBody personnel personnelDetails){
        personnel personnel = PersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        personnel.setNom(personnelDetails.getNom());
        personnel.setPrenom(personnelDetails.getPrenom());
        personnel.setSpecialite(personnelDetails.getSpecialite());
        personnel.setDiplome(personnelDetails.getDiplome());
        personnel.setDateDeNaissance(personnelDetails.getDateDeNaissance());
        personnel.setNumeroCin(personnelDetails.getNumeroCin());

        personnel updatedPersonnel = PersonnelRepository.save(personnel);
        return ResponseEntity.ok(updatedPersonnel);
    }

    // delete personnel rest api
    @DeleteMapping("/personnels/{id}")
    public ResponseEntity<Map<String, Boolean>> deletepersonnel(@PathVariable Long id){
        personnel personnel = PersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        PersonnelRepository.delete(personnel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
