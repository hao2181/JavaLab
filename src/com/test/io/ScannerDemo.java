/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author zhanghao
 *
 */
public class ScannerDemo {
	
	public static void main(String[] args)  {
/*		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num);
		float f = sc.nextFloat();
		System.out.println(f);*/
		File f1= new File("D:"+File.separator+"test.java");
		Scanner sc1=null;
		try {
			sc1 = new Scanner(f1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        String str = sc1.next();
		
		System.out.println("读取到的内容:"+str);
	}
}
