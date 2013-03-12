/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhanghao
 *
 */
public class FileCopy {

	/** 文件之间的拷贝
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		File f1 = new File("D:"+File.separator+"test.java");
		InputStream in = new FileInputStream(f1);
		//byte[] b = new byte[(int)f1.length()];
		
		File f2 = new File("D:"+File.separator+"test1.java");
		OutputStream os = new FileOutputStream(f2);
		int temp = 0;
		while((temp=in.read())!=(-1)){
				os.write(temp);
		}
		os.close();
		in.close();
	}

}
