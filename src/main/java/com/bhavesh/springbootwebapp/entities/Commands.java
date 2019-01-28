/**
 * 
 */
package com.bhavesh.springbootwebapp.entities;

/**
 * @author bhaveshjain
 *
 */
public enum Commands {

	PLACE("PLACE"), MOVE ("MOVE"), LEFT ("LEFT") , RIGHT ("RIGHT"), REPORT ("REPORT");
	
	String value;
	Commands(String value) {
		this.value = value;
	}
	
}
