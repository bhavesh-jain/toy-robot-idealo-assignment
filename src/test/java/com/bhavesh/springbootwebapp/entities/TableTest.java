/**
 * 
 */
package com.bhavesh.springbootwebapp.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author bhaveshjain
 *
 */
public class TableTest {

	/**
	 * 
	 */
	public TableTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void isValidCoOrdinatesTest() {
		assertEquals(true, Table.isValidCoOrdinates(0, 0));
		assertEquals(false, Table.isValidCoOrdinates(-2, 0));
		assertEquals(false, Table.isValidCoOrdinates(0, -1));
		assertEquals(true, Table.isValidCoOrdinates(2, 3));
	}
}
