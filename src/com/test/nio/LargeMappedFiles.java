package com.test.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class LargeMappedFiles {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		File[] files = new File[] { new File("C:\\fff.xml"),
				new File("c:\\111.xml") };
		ArrayList<String> ls = search(files, "china");
		for (String l : ls) {
			System.out.println(l);
		}
	}

	public static ArrayList<String> search(File[] files, String target)
			throws FileNotFoundException, IOException {
		ArrayList<String> result = new ArrayList<String>();
		for (File src : files) {
			MappedByteBuffer dst = new RandomAccessFile(src, "rw").getChannel()
					.map(FileChannel.MapMode.READ_WRITE, 0, src.length()); // 内存映射
			String str = Charset.forName("UTF-8").decode(dst).toString();// 解码
			// 准备进行读
			dst.flip();
			if (str.indexOf(target) != -1) {
				result.add(src.getName());
			}
			dst.clear();
		}
		return result;
	}

}
