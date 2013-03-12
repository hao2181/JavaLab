package com.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class CopyFile {
	
	public static void main(String[] args) throws Exception {
		File f1  = new File("c:\\fff.xml");
		File f2  = new File("c:\\111.xml");
		TestN t = new TestN();
		t.copyFile(f1, f2);
		System.out.println("copy complete");
	}
}

class TestN{
	public static void copyFile(File src,File dst) throws IOException{
		
		FileChannel fin = new FileInputStream(src).getChannel();
		
		FileChannel fout = new FileOutputStream(dst).getChannel();
		
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		while(fin.read(buf)!=-1){
			buf.flip();
			fout.write(buf); 
			buf.clear();
		}
	}
}