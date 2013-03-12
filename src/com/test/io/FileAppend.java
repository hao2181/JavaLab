/**
 * 
 */
package com.test.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhanghao
 *
 */
public class FileAppend {
	/**
	 * @author zhanghao
	 * @date  2011-9-20
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("D:"+File.separator+"hello.txt");
		
		//BufferedWriter fos = new BufferedWriter(new FileWriter("D:"+File.separator+"hello.txt", true));
		OutputStream fos = new FileOutputStream(f,true);
		fos.write(("商户名称：西安银信博锐\r\n").getBytes());
		fos.write(("交易流水号：123456\r\n").getBytes());
		fos.write(("时间：2013-02-22 12:33:35\r\n").getBytes());
		fos.write(("交易信息：交易成功\r\n").getBytes());			
		fos.write(("卡号：123456\r\n").getBytes());
		fos.write(("购买量：\r\n").getBytes());
		fos.write(("冷水：5吨，3.3元\r\n").getBytes());
		fos.write(("热水：10吨，36.5元\r\n").getBytes());
		fos.write(("电量：100度，100元\r\n").getBytes());
		fos.close();
/*		fos.write(("商户名称：西安银信博锐\r\n"));
		fos.write(("交易流水号：123456\r\n"));
		fos.write(("时间：2013-02-22 12:33:35\r\n"));
		fos.write(("交易信息：交易成功\r\n"));			
		fos.write(("卡号：123456\r\n"));
		fos.write(("购买量：\r\n"));
		fos.write(("冷水：5吨，3.3元\r\n"));
		fos.write(("热水：10吨，36.5元\r\n"));
		fos.write(("电量：100度，100元\r\n"));*/
		fos.close();
	}

}
