/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author zhanghao
 *
 */
public class ReaderFile {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("D:"+File.separator+"test.java");
		Reader read = new FileReader(f);
		char[] ch=new char[100]; 
		int len = read.read(ch);
		read.close();
/*        int temp=0;  
        int count=0;  
        while((temp=read.read())!=(-1)){  
            ch[count++]=(char)temp;  
        }  */
		System.out.println(new String(ch,0,len));
	}

}
