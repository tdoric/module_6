package com.example.m6.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.m6.exception.ErrorExc;
import com.example.m6.response.CreateGroupResponse;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({ ErrorExc.class })
    public ResponseEntity<CreateGroupResponse>  handleException(ErrorExc exc) {
		return ResponseEntity
				.badRequest()
				.body(new CreateGroupResponse(exc.getMessage()));
    }

}


