/**
 * 
 */
package com.sarshalom.io;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public interface Writer {
	
	public void write(String line) throws Exception;
	public void close() throws Exception;
}
