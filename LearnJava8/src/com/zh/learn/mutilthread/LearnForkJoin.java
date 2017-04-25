package com.zh.learn.mutilthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

import com.zh.learn.testBean.Folder;

public class LearnForkJoin {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Folder folder = Folder.fromDirectory(new File("D:\\log"));
		System.out.println(forkJoinPool.invoke(new FolderSearchTask(folder, "com")));
		forkJoinPool.shutdown();
	}

}
