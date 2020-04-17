/**
 * 
 */
package com.sarshalom.io.impl;

import java.io.File;
import java.util.Scanner;

import com.sarshalom.io.Reader;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public class FileReader implements Reader{

	private Scanner sc;
	
	public FileReader(String filePath) throws Exception {
		 sc = new Scanner(new File(filePath)); 
	}

	@Override
	public boolean hasNextLine() {
		return sc.hasNextLine();		
	}

	@Override
	public String nextLine() {
		if(hasNextLine())
			return sc.nextLine(); 
		
		return null;
	}

	@Override
	public void close() {
		sc.close();
	}
}
