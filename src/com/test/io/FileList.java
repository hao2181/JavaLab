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
		String[] s = f.list(); //�����ַ�������
		File[] s1 = f.listFiles();//�ļ�����
		for(int i = 0 ;i<s.length;i++){
			System.out.println(s[i]+"-------"+s1[i]);
		}
	}

}
