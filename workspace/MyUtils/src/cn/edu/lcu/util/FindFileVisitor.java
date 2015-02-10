package cn.edu.lcu.util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FindFileVisitor extends SimpleFileVisitor<Path> {
	private PathMatcher matcher = null;
	private ArrayList<Path> list = new ArrayList<>();
	
	public FindFileVisitor(String pattern) {
		super();
		// 这里需要匹配文件名，所以我们使用glob:
		matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		// 如果需要使用正则表达式可以使用下面的
//		matcher = FileSystems.getDefault().getPathMatcher("regex:" + pattern);
	}
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		Path name = file.getFileName();
		System.out.println("Examing: " + name);
		if (matcher.matches(name)) {
			list.add(file);
		}
		return FileVisitResult.CONTINUE;
	}
	public ArrayList<Path> getList() {
		return list;
	}

}

