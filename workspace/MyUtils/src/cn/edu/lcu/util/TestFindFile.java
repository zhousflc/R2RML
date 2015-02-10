package cn.edu.lcu.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import cn.edu.lcu.util.FindFileVisitor;

public class TestFindFile {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("d:","prog");
		FindFileVisitor visitor = new FindFileVisitor(".txt");
		Files.walkFileTree(path, visitor);
		
		for (Path file : visitor.getList()) {
			// 输出绝对路径
			System.out.println(file.toRealPath(LinkOption.NOFOLLOW_LINKS));
		}
	}

}



