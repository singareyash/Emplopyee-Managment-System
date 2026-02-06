package com.EmplopyeemanagmentByyash.Exception;

import com.EmplopyeemanagmentByyash.DTO.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNOtFoundException(IDNotFoundException exception){
        ResponseStructure response=new ResponseStructure();
        response.setMessage("Id Not Found here ");
        response.setData(exception.getMessage());
        response.setStatuscode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNorecordFoundException(NoRecordFoundException exception){
        ResponseStructure response=new ResponseStructure();
        response.setMessage("NoRecord  Found here ");
        response.setData(exception.getMessage());
        response.setStatuscode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
    }
}
