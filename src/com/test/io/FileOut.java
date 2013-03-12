/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhanghao
 *
 */
public class FileOut {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("D:"+File.separator+"hello.txt");
		try {
			OutputStream fos = new FileOutputStream(f);
			String s="ÄãºÃ";
			byte[] b = s.getBytes();
			fos.write(b);
		  /*for(int i =0 ;i<b.length;i++){
				fos.write(b);
			}*/
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
