package com.zh.learn.testBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Folder {
	private final List<Folder> subFolders;
	private final List<Document> documents;
	public Folder(List<Folder> subFolders, List<Document> documents) {
		super();
		this.subFolders = subFolders;
		this.documents = documents;
	}
	
	public List<Folder> getSubFolders(){
		return this.subFolders;
	}
	
	public List<Document> getDouments(){
		return this.documents;
	}
	
	/**
	 * 从指定目录中读取文件加或文件，并转化为相应的类
	 * @param dir
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Folder fromDirectory(File dir) throws FileNotFoundException, IOException{
		List<Folder> subFolders = new LinkedList<>();
		List<Document> documents = new LinkedList<>();
		for(File file : dir.listFiles()){
			if(file.isDirectory()){
				subFolders.add(Folder.fromDirectory(file));
			}
			if(file.isFile()){
				documents.add(Document.fromFile(file));
			}
		}
		return new Folder(subFolders,documents);
	}
	
	

}
