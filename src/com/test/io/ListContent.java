/**
 * 
 */
package com.test.io;

import java.io.File;

/**
 * @author zhanghao
 *
 */
public class ListContent {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("D:"+File.separator);
		print(f);
		
	}
	public static void print(File f){
		if(f!=null){
			if(f.isDirectory()){
				File[] s = f.listFiles();
				if(s!=null){
					for(int i = 0;i<s.length;i++){
						print(s[i]);
					}
				}
			}else{
				System.out.println(f);
			}
		}	
	}
}
