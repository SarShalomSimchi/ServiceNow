/**
 * 
 */
package com.sarshalom.analyzers.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sarshalom.analyzers.Analyzer;
import com.sarshalom.formatters.Formatter;
import com.sarshalom.io.Reader;



/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public class InvestigatorAnalyzer implements Analyzer{

	private static final String DATE_REGEX = "[[0-9],/:,/-]";
	
	private Map<String, Map<String, List<String>>> patternToDiff = new HashMap<>();
	private Reader reader;
	
	/**
	 * @param reader - enables to read from all kinds of inputs - file, stream, etc.
	 */
	public InvestigatorAnalyzer(Reader reader) {
		this.reader = reader;
	}
	
	@Override
	public void analyze() {
		while (reader.hasNextLine()) {
			process(reader.nextLine());
		}
		
		reader.close();
	}

	/**
	 * @param formatter - enables enable all kinds of formats 
	 */
	@Override
	public void print(Formatter formatter) throws Exception {
		for(Map<String, List<String>> changingWordToLines : patternToDiff.values()) {
			
			if(changingWordToLines.size() > 1) {
				try {
					formatter.write(changingWordToLines);
				}catch (Exception e) {
					formatter.close();
					throw e;
				}
			}
		}
		
		formatter.close();
	}
	
	/**
	 * aggregate lines by similar pattern      
	 */
	private void process(String line) {
		String[] words = getWords(line);
		
		for (int i = 0; i < words.length; i++) {
			String pattern = generatePattern(words, i); 
			
			if (!patternToDiff.containsKey(pattern)) {
				Map<String, List<String>> changingWordToLines = new HashMap<String, List<String>>();
				addChangingWordAndLine(line, words, i, changingWordToLines);
				patternToDiff.put(pattern, changingWordToLines);
			} else {
				Map<String, List<String>> diffWordToLines = patternToDiff.get(pattern);
				
				if (diffWordToLines.containsKey(words[i])) 
					diffWordToLines.get(words[i]).add(line);
				else {
					addChangingWordAndLine(line, words, i, diffWordToLines);
				}
			}
		}
	}
	
	private void addChangingWordAndLine(String line, String[] words, int i, Map<String, List<String>> changingWordToLines) {
		List<String> lines = new ArrayList<>();
		lines.add(line);
		changingWordToLines.put(words[i], lines);
	}

	private String generatePattern(String[] words, int i) {
		String[] slice1 = Arrays.copyOfRange(words, 0, i);
		String[] slice2 = Arrays.copyOfRange(words, i + 1,  words.length);
		String pattern = (String.join("", slice1) + String.join("", slice2));
		
		return pattern;
	}

	private String[] getWords(String line) {
		String wordsOnly = line.replaceAll(DATE_REGEX, "").trim();
		String[] words = wordsOnly.split("\\s+");
		
		return words;
	}
}
