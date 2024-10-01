package com.smhj.ProductService.controllers.advices;

import com.smhj.ProductService.dtos.ExceptionDto;
import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.DuplicateCategoryFoundException;
import com.smhj.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice // global
//@ControllerAdvice(assignableTypes = {ProductController.class}) // specfic
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setStatus("Failure");
        exceptionDto.setMessage(e.getMessage());
        return exceptionDto;
    }

    @ExceptionHandler(DuplicateCategoryFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionDto handleDuplicateCategoryFoundException(DuplicateCategoryFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setStatus("Failure");
        exceptionDto.setMessage(e.getMessage());
        return exceptionDto;
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionDto handleCategoryNotFoundException(CategoryNotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setStatus("Failure");
        exceptionDto.setMessage(e.getMessage());
        return exceptionDto;
    }

//    with response entity
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException1(ProductNotFoundException e){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setStatus("Failure");
//        exceptionDto.setMessage(e.getMessage());
//        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//    }

}
