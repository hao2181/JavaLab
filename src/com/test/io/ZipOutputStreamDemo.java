/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 */
	import java.io.File;  
	import java.io.FileInputStream;  
	import java.io.FileOutputStream;  
	import java.io.IOException;  
	import java.io.InputStream;  
	import java.util.zip.ZipEntry;  
	import java.util.zip.ZipOutputStream;  
	 
	public class ZipOutputStreamDemo{  
	    public static void main(String[] args) throws IOException{  
	        File file = new File("d:" + File.separator + "hello.text");  
	        File zipFile = new File("d:" + File.separator + "hello1.zip");  
	        InputStream input = new FileInputStream(file);  
	        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(  
	                zipFile));  
	        zipOut.putNextEntry(new ZipEntry(file.getName()));  
	        // …Ë÷√◊¢ Õ  
	        zipOut.setComment("hello");  
	        int temp = 0;  
	        while((temp = input.read()) != -1){  
	            zipOut.write(temp);  
	        }  
	        input.close();  
	        zipOut.close();  
	    }  
	} 
