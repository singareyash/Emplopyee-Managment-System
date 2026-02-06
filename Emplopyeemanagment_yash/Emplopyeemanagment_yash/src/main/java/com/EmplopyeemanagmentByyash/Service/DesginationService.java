package com.EmplopyeemanagmentByyash.Service;

import com.EmplopyeemanagmentByyash.DTO.ResponseStructure;
import com.EmplopyeemanagmentByyash.Entity.Desgination;
import com.EmplopyeemanagmentByyash.Reposistory.DesignationReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesginationService {

    @Autowired
    private DesignationReposistory designationReposistory;

    public ResponseEntity<ResponseStructure<Desgination>> createdesignation(Desgination des) {
        ResponseStructure res = new ResponseStructure();
        res.setStatuscode(HttpStatus.CREATED.value());
        res.setMessage("Designation added successfully");
        res.setData(designationReposistory.save(des));

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<List>> getAllDesignation()
    {
        List<Desgination> list=designationReposistory.findAll();
        ResponseStructure<List> res=new ResponseStructure<>();
        res.setMessage("Designation fetched sucuesfully");
        res.setStatuscode(HttpStatus.OK.value());
        res.setData(list);

        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

}
