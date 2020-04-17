/**
 * 
 */
package com.sarshalom.io;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public interface Reader {
	
	public boolean hasNextLine();
	public String nextLine();
	public void close();
}
