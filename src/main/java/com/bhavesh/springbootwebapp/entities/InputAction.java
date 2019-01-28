/**
 * 
 */
package com.bhavesh.springbootwebapp.entities;

/**
 * @author bhaveshjain
 *
 */
public class InputAction {
	
	Commands command;
	Position position;
	/**
	 * @param command
	 * @param position
	 */
	public InputAction(Commands command, Position position) {
		super();
		this.command = command;
		this.position = position;
	}
	/**
	 * 
	 */
	public InputAction() {
	}
	/**
	 * @return the command
	 */
	public Commands getCommand() {
		return command;
	}
	/**
	 * @param command the command to set
	 */
	public void setCommand(Commands command) {
		this.command = command;
	}
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Executes the action on the associated ToyRobot.
	 * @param robot
	 * @return 
	 */
	public String execute(ToyRobot robot) {
		String output = null;
			switch(this.getCommand()) {
				case PLACE:
					robot.setPosition(this.getPosition());
					break;
				case MOVE:
					robot.move();
					break;
				case LEFT:
					robot.rotateLeft();
					break;
				case RIGHT:
					robot.rotateRight();
					break;
				case REPORT:
					output = robot.toString();
			}
			return output;
		}

	
}
