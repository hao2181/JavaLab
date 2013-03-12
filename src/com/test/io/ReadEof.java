/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhanghao
 *
 */
public class ReadEof {
	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String fileName = "D:"+File.separator+"hello.txt";
		File f = new File(fileName);
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[1024];
        int count = 0;  
        int temp = 0;
		while((temp=in.read())!=(-1)){
			b[count++]=(byte)temp;
		}
		in.close();
		System.out.println(new String(b));
	}

}
