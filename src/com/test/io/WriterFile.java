/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author zhanghao
 *
 */
public class WriterFile {
	
	public static void main(String[] args) throws IOException{
		File f = new File("d:"+File.separator+"test.java");
		Writer out = new FileWriter(f,true);
		String str = "уе╨ф";
		out.write(str);
		out.close();
	}
}
