package com.sarshalom.formatters.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sarshalom.formatters.Formatter;
import com.sarshalom.io.Writer;

/**
 * @author Sar Shalom Simchi 13/04/2020
 *
 */
public class SimilarGroupFormatter implements Formatter{

	private static String CHANGING_WORDS_PREFIX = "The changing word was: "; 
	private Writer writer;
	
	
	public SimilarGroupFormatter(Writer writer) throws IOException {
		this.writer = writer; 
	}

	public void write(Map<String, List<String>> data) throws Exception{
		List<String> lines = 
				data.values()
				.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		try {
			writer.write(String.join("\n", lines) + "\n" + CHANGING_WORDS_PREFIX + String.join(", ", data.keySet()) + "\n\n");
		} catch (Exception e) {
			close();
			throw e;
		}
	}
	
	@Override
	public void close() throws Exception {
		writer.close();
	}
}