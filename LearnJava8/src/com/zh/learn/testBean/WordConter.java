package com.zh.learn.testBean;

import java.util.List;

public class WordConter {
	
	public static String[] wordsIn(String line){
		return line.trim().split("(\\s|\\p{Punct})+");
	}
	
	public static Long occurrencesCount(Document document,String searchedWord){
		long count = 0;
		List<String> lines = document.getLines();
		for (String line : lines) {
			for(String word : wordsIn(line)){
				if(searchedWord.equals(word)){
					count += 1;
				}
			}
		}
		return count;
	}

}
