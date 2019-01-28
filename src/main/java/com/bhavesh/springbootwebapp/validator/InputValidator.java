/**
 * 
 */
package com.bhavesh.springbootwebapp.validator;

import com.bhavesh.springbootwebapp.entities.Commands;
import com.bhavesh.springbootwebapp.entities.InputAction;
import com.bhavesh.springbootwebapp.entities.Position;
import com.bhavesh.springbootwebapp.exceptions.InvalidInputException;

/**
 * @author bhaveshjain
 *
 */
public class InputValidator {


	/**
	 * Validates and parses the raw input into InputActions Array.
	 * 
	 * @param input
	 * @return
	 * @throws InvalidInputException
	 */
	public static InputAction[] parseRawInput(String rawInput) throws InvalidInputException  {
		
		String[] inputArray = rawInput.split("\n");
		InputAction[] inputActions = new InputAction[inputArray.length];
		int index = 0;
		for(String input: inputArray) {
			String[] commandArray = input.split(" ");
			inputActions[index] = new InputAction();
			inputActions[index].setCommand(Commands.valueOf(commandArray[0].trim()));
			
//	if position elements provided with the command e.g. PLACE 0,0,NORTH 
			if (commandArray.length >= 2) {
				String[] positionElements = commandArray[1].split(",");
				Position pos = new Position();
				pos.setX(Integer.parseInt(positionElements[0].trim()));
				pos.setY(Integer.parseInt(positionElements[1].trim()));
				
//	if direction provided along with position co-ordinates
				if (positionElements.length == 3) {
					pos.setDirection(positionElements[2].trim());
				}
				inputActions[index].setPosition(pos);
				
			}
			index++;
		}
		
		return inputActions;
		
	}

	
}
