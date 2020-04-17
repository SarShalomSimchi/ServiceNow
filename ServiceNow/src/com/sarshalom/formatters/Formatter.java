/**
 * 
 */
package com.sarshalom.formatters;

import java.util.List;
import java.util.Map;

/**
 * @author Sar Shalom Simchi 17/04/2020
 *
 */
public interface Formatter {

	public void write(Map<String, List<String>> data) throws Exception; 
	public void close() throws Exception; 
}
