/**
 * 
 */
package com.bhavesh.springbootwebapp.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bhavesh.springbootwebapp.entities.Commands;
import com.bhavesh.springbootwebapp.entities.Directions;
import com.bhavesh.springbootwebapp.entities.InputAction;

/**
 * @author bhaveshjain
 *
 */
public class InputValidatorTest {

	/**
	 * 
	 */
	public InputValidatorTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void parseRawInputTest() {
		String rawInput = "PLACE 0,0,NORTH";
		InputAction[] output = InputValidator.parseRawInput(rawInput);
		assertEquals(Commands.PLACE, output[0].getCommand());
		assertEquals(0, output[0].getPosition().getX());
		assertEquals(0, output[0].getPosition().getY());
		assertEquals(Directions.NORTH, output[0].getPosition().getDirection());
	}
}
