/**
 * 
 */
package com.sarshalom;

import com.sarshalom.analyzers.Analyzer;
import com.sarshalom.analyzers.impl.InvestigatorAnalyzer;
import com.sarshalom.formatters.Formatter;
import com.sarshalom.formatters.impl.SimilarGroupFormatter;
import com.sarshalom.io.Writer;
import com.sarshalom.io.impl.FileReader;
import com.sarshalom.io.impl.FileWriter;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public class InvestigatorAnalyzerDemo {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("input\\investigatorLog.txt");
			Analyzer investigatorAnalyzer = new InvestigatorAnalyzer(fileReader);
			investigatorAnalyzer.analyze();
			
			Writer fileWriter = new FileWriter("C:\\ServiceNow\\output.txt") ;
			Formatter similarGroupFormatter = new SimilarGroupFormatter(fileWriter);
			investigatorAnalyzer.print(similarGroupFormatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
