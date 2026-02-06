package com.EmplopyeemanagmentByyash.Controller;

import com.EmplopyeemanagmentByyash.DTO.ResponseStructure;
import com.EmplopyeemanagmentByyash.Entity.Emplopyee;
import com.EmplopyeemanagmentByyash.Service.EmplopyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class EmplopyeeController{

    @Autowired
    private EmplopyeeService emplopyeeService;


    @PostMapping
    public ResponseEntity<ResponseStructure<Emplopyee>> createEmployee(
            @RequestBody Emplopyee emplopyee) {
        return emplopyeeService.createEmployee(emplopyee);
    }


    @GetMapping
    public ResponseEntity<ResponseStructure<List<Emplopyee>>> getAllEmployees() {
        return emplopyeeService.getAllEmployee();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Emplopyee>> getEmployeeById(
            @PathVariable Integer id) {
        return emplopyeeService.findbyidEmplopyee(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Emplopyee>> updateEmplopyees(
            @PathVariable Integer id,
            @RequestBody Emplopyee e
    ){
        return emplopyeeService.updateEmplopyee(e, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteEmplopyee(@PathVariable Integer id){
        return emplopyeeService.deleteEmplopyee(id);
    }
    

}
