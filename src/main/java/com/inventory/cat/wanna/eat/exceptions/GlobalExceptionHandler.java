package com.inventory.cat.wanna.eat.exceptions;

import com.inventory.cat.wanna.eat.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundCurrentFoodPlanException.class)
    public ResponseEntity<Response> notFoundCurrentFoodPlanHandler(NotFoundCurrentFoodPlanException e){
        Response response = new Response(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<Response> notFoundEntityHandler(NotFoundEntityException e){
        Response response = new Response(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
