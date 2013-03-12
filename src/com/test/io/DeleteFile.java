/**
 * 
 */
package com.test.io;

import java.io.File;

/**
 * @author zhanghao
 *
 */
public class DeleteFile {
	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("d:"+File.separator+"text.java");
		if(f.exists()){
			f.delete();
		}else{
			System.out.println("н╢ур╣╫нд╪Ч");
		}

	}

}
