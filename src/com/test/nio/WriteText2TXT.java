package com.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteText2TXT {
	
	public static void main(String[] args) throws IOException {
		File f = new File("c:\\fff.xml");
		FileChannel fc = new FileOutputStream(f).getChannel();//写入是输出流
		ByteBuffer buf = ByteBuffer.wrap("china nio group ".getBytes());
		fc.write(buf);
		fc.close();
		
		RandomAccessFile ra = new RandomAccessFile(f,"rw");
		FileChannel fc1 = ra.getChannel();//写入是输出流
		fc1.position(fc1.size());  //定位
		fc1.write(ByteBuffer.wrap("some more".getBytes()));  
        fc1.close();  
        
        FileChannel  fc2 = new FileInputStream("c:\\fff.xml").getChannel();  
        ByteBuffer buf2 = ByteBuffer.allocate(1024);  
        fc2.read(buf2);  
        buf2.flip();  
        while(buf2.hasRemaining()) {  //判断是否到达缓冲区上届 没有的话 返回true
        	System.out.println(buf2.hasRemaining());
            System.out.print((char)buf2.get());  
        }  
        
        
	}
}
