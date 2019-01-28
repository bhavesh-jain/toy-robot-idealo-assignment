/**
 * 
 */
package com.bhavesh.springbootwebapp.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.bhavesh.springbootwebapp.exceptions.InvalidInputException;

/**
 * @author bhaveshjain
 *
 */
public class ToyRobotTest {

	/**
	 * 
	 */
	public ToyRobotTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void setPositionTest() {
		ToyRobot robot = new ToyRobot();
		robot.setPosition(new Position(0, 0, Directions.NORTH));
		
		assertEquals(0, robot.getPosition().getX());
		assertEquals(0, robot.getPosition().getY());
		assertEquals(Directions.NORTH, robot.getPosition().getDirection());
	
		robot.setPosition(new Position(-2, 0, Directions.NORTH));
//		Following assertion confirms robot new placement is ignored to avoid the fall.
		assertEquals(0, robot.getPosition().getX());
		assertEquals(0, robot.getPosition().getY());
		assertEquals(Directions.NORTH, robot.getPosition().getDirection());

	}
	
	
	@Test
	public void moveTest() {
		ToyRobot robot = new ToyRobot(new Position(0, 0, Directions.NORTH));
		robot.move();
		
		assertEquals(0, robot.getPosition().getX());
		assertEquals(1, robot.getPosition().getY());
		assertEquals(Directions.NORTH, robot.getPosition().getDirection());
		
		robot.setPosition(new Position(0, 5, Directions.NORTH));
		
		robot.move();
//		Following assertion confirms robot move is ignored to avoid the fall.
		assertEquals(0, robot.getPosition().getX());
		assertEquals(5, robot.getPosition().getY());
		assertEquals(Directions.NORTH, robot.getPosition().getDirection());
		
	}
	
}
