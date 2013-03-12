/**
 * 
 */
package com.test.io;

import java.io.File;

/**
 * @author zhanghao
 *
 */
public class FileList {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		String FileName="d:"+File.separator;
		File f = new File(FileName);
		if(f.isDirectory()){
			System.out.println("+++++++++++++++++++Yes+++++++++++++++++++");
		}else{
			System.out.println("+++++++++++++++++++No++++++++++++++++++++");
		}
		String[] s = f.list(); //名称字符串数组
		File[] s1 = f.listFiles();//文件数组
		for(int i = 0 ;i<s.length;i++){
			System.out.println(s[i]+"-------"+s1[i]);
		}
	}

}
