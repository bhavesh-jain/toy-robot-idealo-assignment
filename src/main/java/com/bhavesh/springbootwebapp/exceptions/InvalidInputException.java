/**
 * 
 */
package com.bhavesh.springbootwebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bhaveshjain
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5925538747109268700L;

	/**
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



}
