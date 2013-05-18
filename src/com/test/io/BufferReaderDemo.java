/**
 * 
 */
package com.test.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhanghao
 *
 */
public class BufferReaderDemo {

	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//OutputStreramWriter��������ַ���ת��Ϊ�ֽ���
		//InputStreamReader��������ֽ���ת��Ϊ�ַ���
		try {
			System.out.println("��������ǣ�"+br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
