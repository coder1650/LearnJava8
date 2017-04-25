package com.zh.learn.testBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Document {
	
	private final List<String> lines;
	
	public Document(List<String> lines){
		this.lines = lines;
	}
	
	public List<String> getLines(){
		return this.lines;
	}
	
	public static Document fromFile(File file) throws FileNotFoundException, IOException{
		List<String> lines = new LinkedList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			while(line != null){
				lines.add(line);
				line = reader.readLine();
			}
		}
		return new Document(lines);
	}

}
