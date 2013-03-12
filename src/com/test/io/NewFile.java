/**
 * 
 */
package com.test.io;

import java.io.File;

/**
 * @author zhanghao
 *
 */
public class NewFile {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		
		File f= new File("D:\\text.java");
		try{
			f.createNewFile();
			System.out.println(File.separator);//½¡×³ÐÔ windows linux
			System.out.println(File.pathSeparator);
			System.out.println(File.pathSeparatorChar);
			System.out.println(File.separatorChar);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
