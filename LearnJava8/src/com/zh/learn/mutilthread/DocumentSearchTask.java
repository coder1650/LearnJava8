package com.zh.learn.mutilthread;

import java.util.concurrent.RecursiveTask;

import com.zh.learn.testBean.Document;
import com.zh.learn.testBean.WordConter;

public class DocumentSearchTask extends RecursiveTask<Long>{
	private final Document document;
	private final String searchedWord;
	
	public DocumentSearchTask(Document document, String searchedWord) {
		super();
		this.document = document;
		this.searchedWord = searchedWord;
	}

	@Override
	protected Long compute() {
//		System.out.println("invoke document compute....");
		long count = WordConter.occurrencesCount(document, searchedWord);
//		System.out.println("count:"+count);
		return count;
	}

}
