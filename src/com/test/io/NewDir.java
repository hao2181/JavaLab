/**
 * 
 */
package com.test.io;

import java.io.File;

/**
 * @author zhanghao
 *
 */
public class NewDir {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		
		File  f = new File("D:"+File.separator+"hello");
		try{
			f.mkdir();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
