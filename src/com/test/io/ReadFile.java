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
public class ReadFile {

		public static void main(String[] args) throws IOException{
			File f = new File("D:"+File.separator+"hello.txt");
			InputStream in = new FileInputStream(f);
			byte[] b = new byte[1024];
			//byte[] b = new byte[(int)f.length()]; //节省空间 预设文件大小的空间
	        //for (int i = 0; i < b.length; i++) {  
	        //    b[i]=(byte)in.read();  
	        //} 
			int len = in.read(b);
			in.close();
			System.out.println(new String(b,0,len));		
		}
}
