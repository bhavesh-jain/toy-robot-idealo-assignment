/**
 * 
 */
package com.bhavesh.springbootwebapp.entities;


/**
 * @author bhaveshjain
 *
 */
public class Table {

	static int length = 5;
	/**
	 * @return the length
	 */
	public static int getLength() {
		return length;
	}


	/**
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}


	static int width = 5;
	
	public static boolean isValidCoOrdinates(int x, int y) {
		if(x > width || x < 0 || y > length || y < 0)
			return false;
		
		return true;
	}

}
