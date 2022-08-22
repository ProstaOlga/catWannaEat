package com.inventory.cat.wanna.eat.exceptions;

import com.inventory.cat.wanna.eat.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundCurrentFoodPlanException.class)
    public ResponseEntity<Response> notFoundCurrentFoodPlanHandler(NotFoundCurrentFoodPlanException e, HttpServletRequest httpServletRequest){
        Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST, httpServletRequest.getServletPath());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<Response> notFoundEntityHandler(NotFoundEntityException e, HttpServletRequest httpServletRequest){
        Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST, httpServletRequest.getServletPath());


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> userNotFoundHandler(UserNotFoundException e, HttpServletRequest httpServletRequest){
        Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST, httpServletRequest.getServletPath());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
