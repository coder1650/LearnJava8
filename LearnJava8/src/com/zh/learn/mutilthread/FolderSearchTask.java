package com.zh.learn.mutilthread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import com.zh.learn.testBean.Document;
import com.zh.learn.testBean.Folder;

public class FolderSearchTask extends RecursiveTask<Long>{
	private final Folder folder;
	private final String searchedWord;
	
	public FolderSearchTask(Folder folder, String searchedWord) {
		super();
		this.folder = folder;
		this.searchedWord = searchedWord;
	}

	@Override
	protected Long compute() {
//		System.out.println("begin....:"+System.currentTimeMillis());
		long count = 0;
		List<RecursiveTask<Long>> forks = new LinkedList<>();
		for(Folder subFolder : folder.getSubFolders()){
			FolderSearchTask task = new FolderSearchTask(subFolder,searchedWord);
			forks.add(task);
			task.fork();
		}
		for(Document document : folder.getDouments()){
			DocumentSearchTask task = new DocumentSearchTask(document, searchedWord);
			forks.add(task);
			task.fork();
		}
		for(RecursiveTask<Long> task : forks){
			count += task.join();
		}
		return count;
	}

}
