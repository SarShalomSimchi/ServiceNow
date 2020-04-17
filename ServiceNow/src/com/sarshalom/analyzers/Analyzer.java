/**
 * 
 */
package com.sarshalom.analyzers;

import com.sarshalom.formatters.Formatter;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public interface Analyzer {
	
	public void analyze();
	public void print(Formatter formatter) throws Exception;
}
