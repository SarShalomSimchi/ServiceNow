/**
 * 
 */
package com.sarshalom.io.impl;

import java.io.IOException;

import com.sarshalom.io.Writer;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public class FileWriter implements Writer{

	private java.io.FileWriter fw;	
	
	public FileWriter(String filePath) throws IOException {
		fw = new java.io.FileWriter(filePath);
	}
	
	@Override
	public void close() throws Exception {
		fw.close();
	}
	
	@Override
	public void write(String line) throws Exception{
		fw.write(line);
	}
}
