/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhanghao
 *
 */
public class SystemOut {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("D:"+File.separator+"test.txt");
		OutputStream out = System.out;
		out.write("уе╨ф".getBytes());
		out.close();
	}

}
