package com.EmplopyeemanagmentByyash.Service;


import com.EmplopyeemanagmentByyash.DTO.ResponseStructure;
import com.EmplopyeemanagmentByyash.Entity.Emplopyee;
import com.EmplopyeemanagmentByyash.Exception.IDNotFoundException;
import com.EmplopyeemanagmentByyash.Exception.NoRecordFoundException;
import com.EmplopyeemanagmentByyash.Reposistory.EmplopyeeReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmplopyeeService
{

    @Autowired
    private EmplopyeeReposistory emplopyeeReposistory;


    public ResponseEntity<ResponseStructure<Emplopyee>> createEmployee(Emplopyee emp) {
        ResponseStructure<Emplopyee> response = new ResponseStructure<>();
        response.setStatuscode(HttpStatus.CREATED.value());
        response.setMessage("Employee created successfully");
        response.setData(emplopyeeReposistory.save(emp));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    public ResponseEntity<ResponseStructure<List<Emplopyee>>> getAllEmployee() {
        ResponseStructure<List<Emplopyee>> response = new ResponseStructure<>();
        response.setStatuscode(HttpStatus.OK.value());
        response.setMessage("Employees fetched successfully");
        response.setData(emplopyeeReposistory.findAll());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Emplopyee>> findbyidEmplopyee(Integer id) {
        Optional<Emplopyee> opt = emplopyeeReposistory.findById(id);

        if (opt.isPresent()) {
            ResponseStructure<Emplopyee> response = new ResponseStructure<>();
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Employee found");
            response.setData(opt.get());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new IDNotFoundException("Employee ID not found: " + id);
        }
    }


    public ResponseEntity<ResponseStructure<Emplopyee>> updateEmplopyee(Emplopyee e, Integer id) {
        Optional<Emplopyee> opt = emplopyeeReposistory.findById(id);

        if (opt.isPresent()) {
            Emplopyee existing = opt.get();

            existing.setName(e.getName());
            existing.setDob(e.getDob());
            existing.setSalary(e.getSalary());
            existing.setGender(e.getGender());
            existing.setDesgination(e.getDesgination());
            existing.setEmailID(e.getEmailID());
            existing.setManager(e.getManager());

            Emplopyee updated = emplopyeeReposistory.save(existing);

            ResponseStructure response = new ResponseStructure();
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("updated sucuessfully");
            response.setData(updated);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new IDNotFoundException("id not found  Emplopyee id here" + id);
        }
    }

    public ResponseEntity<ResponseStructure<String>> deleteEmplopyee(Integer id) {
        Optional<Emplopyee> opt = emplopyeeReposistory.findById(id);

        if (opt.isPresent()) {
            emplopyeeReposistory.deleteById(id);

            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Employee deleted successfully");
            response.setData("Deleted employee with ID: " + id);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new NoRecordFoundException("Employee Record  not found: " + id);
        }

    }
}

