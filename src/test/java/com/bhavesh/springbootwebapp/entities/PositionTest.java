package com.bhavesh.springbootwebapp.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {

	public PositionTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void rotateRightTest() {
		Position pos = new Position(0, 0, Directions.NORTH);
		pos.rotateRight();
		assertEquals(Directions.EAST, pos.getDirection());
	}
	
	@Test
	public void rotateLeftTest() {
		Position pos = new Position(0, 0, Directions.NORTH);
		pos.rotateLeft();
		assertEquals(Directions.WEST, pos.getDirection());
	}

}
