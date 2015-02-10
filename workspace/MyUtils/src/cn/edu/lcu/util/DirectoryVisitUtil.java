package cn.edu.lcu.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryVisitUtil {
	
	public static void main(String[] args) {
		//
		List<String> fileList = new ArrayList<String>(); 

		try {
			//可以遍历任意目录下的文件
//			fileList = new MyFileVisitor("txt", fileList, "d:", "\\").getFileList(); //查找"d:\" 的.txt文件
//			fileList = new MyFileVisitor("pdf", fileList, "d:", "\\", "pdf").getFileList();//查找"d:\pdf" 的.pdf文件
//			fileList = new MyFileVisitor("pdf", fileList, "e:", "\\").getFileList();//查找"e:\" 的.pdf文件
			fileList = new MyFileVisitor("jar", fileList, "d:", "\\", "prog").getFileList();//查找"e:\prog" 的.pdf文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Iterator<String> iter = fileList.iterator(); iter.hasNext(); ) { 			
			System.out.println(iter.next());
		}

	}
}

class MyFileVisitor {
	private String fileSuffix;
	private List<String> fileList;
	
	//其中fileSuffix表示文件后缀,
	MyFileVisitor(String fileSuffix, List<String> fileList, String first, String ... more) throws IOException {		
		this.fileSuffix = fileSuffix;
		this.fileList = fileList;		
		
		// 遍历目录下的所有文件和子目录
		Files.walkFileTree(Paths.get(first, more), new MySimpleFileVisitor(fileSuffix, fileList));		
	}
	
	public List<String> getFileList() {
		return fileList;
	}
}


class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

	private String fileSuffix;
	private List<String> fileList;
	
	MySimpleFileVisitor(String fileSuffix, List<String> fileList) {
		this.fileSuffix = fileSuffix;
		this.fileList = fileList;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		//System.out.println("正在访问" + file + " 文件 ");
		if (file.toString().endsWith("." + fileSuffix)) {
//			System.out.println("已经找到目标文件----: " + file);
			fileList.add(file.toString());
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		//System.out.println("----正在访问: " + dir + "目录----");
		return FileVisitResult.CONTINUE;
	}
}
