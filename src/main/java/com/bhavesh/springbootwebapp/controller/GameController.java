package com.bhavesh.springbootwebapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bhavesh.springbootwebapp.entities.InputAction;
import com.bhavesh.springbootwebapp.entities.ToyRobot;
import com.bhavesh.springbootwebapp.exceptions.InvalidInputException;
import com.bhavesh.springbootwebapp.validator.InputValidator;



@Controller
public class GameController {
	
	@PostMapping("/robot")
	public ResponseEntity<String> commandRobot(@RequestBody String rawInput) {
		
		InputAction[] inputActions = InputValidator.parseRawInput(rawInput);
		
		if(null == inputActions || inputActions.length == 0) {
			return ResponseEntity.badRequest().build();
		}
			
		ToyRobot robot = new ToyRobot();
		try {
			String output = null;
			for(InputAction inputAction: inputActions) {
				output = inputAction.execute(robot);
			}
				
			return ResponseEntity.ok(output);
		} catch(InvalidInputException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}

	}

}
