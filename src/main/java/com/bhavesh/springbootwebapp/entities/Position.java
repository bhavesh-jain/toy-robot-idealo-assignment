package com.bhavesh.springbootwebapp.entities;

import com.bhavesh.springbootwebapp.exceptions.InvalidInputException;

public class Position {

	int x;
	int y;
	Directions direction;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	public Position(int x, int y, Directions direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Position() {
		
	}
	
	public void rotateRight() {
		

		Directions[] directionsArray = Directions.values();
		int index = 0;
		int newIndex = 0;
		for (Directions direction : directionsArray) {
			if (direction.equals(this.direction)) {
				newIndex = index == 0 ? (directionsArray.length-1) : (index -1);
				break;
			}
			index++;
		}
		this.direction = directionsArray[newIndex];
		System.out.println("The new direction after rotateLeft is: " + this.direction);
	}
	
	public void rotateLeft() {
		Directions[] directionsArray = Directions.values();
		int index = 0;
		int newIndex = 0;
		for (Directions direction : directionsArray) {
			if (direction.equals(this.direction)) {
				newIndex = index == (directionsArray.length-1) ? 0 : (index + 1);
				break;
			}
			index++;
		}
		this.direction = directionsArray[newIndex];
		System.out.println("The new direction after rotateRight is: " + this.direction);
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the direction
	 */
	public Directions getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		try {
			this.direction = Directions.valueOf(direction);
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException("Invalid direction: " + direction);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Co-ordinates are X: %d, Y: %d and facing %s", x, y, direction);
	}
	
	
	
}
