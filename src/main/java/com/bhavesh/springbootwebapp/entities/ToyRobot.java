package com.bhavesh.springbootwebapp.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bhavesh.springbootwebapp.exceptions.InvalidInputException;

/**
 * 
 * @author bhaveshjain
 *
 */
public class ToyRobot {
	
	private final Logger log = LoggerFactory.getLogger(ToyRobot.class);
	private Position position;

	/**
	 * 
	 */
	public ToyRobot() {

	}

	public ToyRobot(Position position) throws InvalidInputException {
		this.setPosition(position);
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 * @throws InvalidInputException 
	 */
	public void setPosition(Position position) throws InvalidInputException {
//	Direction of robot is defaulted to South if the direction is not provided while placing.
		if (position.getDirection() == null ) {
			position.setDirection(Directions.SOUTH.name());
		}
		
		if (Table.isValidCoOrdinates(position.getX(), position.getY())) {
			try {
				this.position = position;
				log.debug("Robot's new position is:" + this.position);
			} catch (IllegalArgumentException ex) {
				throw new InvalidInputException(ex.getMessage());
			}
		} else {
			log.debug("Invalid co-ordinates provided, can't position the Robot");
		}
	}

	/**
	 * move the toy robot one unit forward in the direction it is currently facing.
	 * 
	 * @return
	 * @throws InvalidInputException
	 */
	public void move() throws InvalidInputException {
		Position currentPosition = this.getPosition();
		if(null == currentPosition) {
			throw new InvalidInputException("ROBOT MISSING");
		} else {
			int newX=currentPosition.x;
			int newY=currentPosition.y;
			switch (currentPosition.direction) {
				case NORTH:
					if(newY < Table.getLength())
						newY++;
					break;
				case WEST:
					if(newX > 0)
						newX--;
					break;
				case SOUTH:
					if(newY > 0)
						newY--;
					break;
				case EAST:
					if(newX < Table.getWidth())
					newX++;

			}
			
			if(currentPosition.x == newX && currentPosition.y ==newY) {
				log.debug("Ignored the move command to avoid fall.");
			} else {
				this.position.setX(newX);
				this.position.setY(newY);
				log.debug("Robot has moved to new position: " + this.position);
			}
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Position pos = this.getPosition();
		if (null == pos) {
			return "ROBOT MISSING";
		} else {
			return pos.getX() + ", " + pos.getY()  + ", " + pos.getDirection().name() ;
		}
	}

	/**
	 *  Rotate the robot to left
	 */
	public void rotateLeft() {
		Position currentPosition = this.getPosition();
		if(null == currentPosition) {
			log.debug("ROBOT MISSING");
		} else {
			currentPosition.rotateLeft();
			log.debug("Robot's new direction after rotating left: " + currentPosition.getDirection());
		}
	}

	/**
	 * Rotates the robot to Right.
	 */
	public void rotateRight() {
		Position currentPosition = this.getPosition();
		if(null == currentPosition) {
			log.debug("ROBOT MISSING");
		} else {
			currentPosition.rotateRight();
			log.debug("Robot's new direction after rotating right: " + currentPosition.getDirection());
		}
	}

}
