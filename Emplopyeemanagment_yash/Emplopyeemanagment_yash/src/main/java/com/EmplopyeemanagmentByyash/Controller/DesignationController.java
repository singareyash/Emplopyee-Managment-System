package com.EmplopyeemanagmentByyash.Controller;

import com.EmplopyeemanagmentByyash.DTO.ResponseStructure;
import com.EmplopyeemanagmentByyash.Entity.Desgination;
import com.EmplopyeemanagmentByyash.Service.DesginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designation")
@CrossOrigin("*")
public class DesignationController {
    
    @Autowired
    private DesginationService desginationService;
    
    @PostMapping
    public ResponseEntity<ResponseStructure<Desgination>> saveDesignation(@RequestBody Desgination des){
        return desginationService.createdesignation(des);
    }
    
    @GetMapping
    public ResponseEntity<ResponseStructure<List>> GetAllDesignation()
    {
        return desginationService.getAllDesignation();
    }
}
