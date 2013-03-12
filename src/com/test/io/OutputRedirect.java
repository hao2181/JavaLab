/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author zhanghao
 *
 */
public class OutputRedirect {

	public static void main(String[] args) {
		File f = new File("D:"+File.separator+"test.java");
		System.out.println("Hello");
		try {
			System.setOut(new PrintStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("============Test.java============");
	}
}
