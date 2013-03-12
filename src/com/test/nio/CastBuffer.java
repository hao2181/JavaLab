package com.test.nio;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;


public class CastBuffer {
	
	static byte[] bytes = new byte[] {0, 1, 2, 3, 4, 5, 'a', 'b', 'c'};  
	
	public static void main(String[] args) {
		
		    ByteBuffer buf = ByteBuffer.wrap(bytes);
		    System.out.println(Arrays.toString(buf.array()));  
	        //转换成IntBuffer  
	        IntBuffer iBuf = ((ByteBuffer)buf.rewind()).asIntBuffer();  //rewind 重置 不修改limit的值  flip修改limit的值
	        while(iBuf.hasRemaining()) {  
	            System.out.print(iBuf.get()+",");  
	        }  
	        
	        System.out.println("----------------------");
	        //转换成FloatBuffer  
	        FloatBuffer fBuf = ((ByteBuffer)buf.rewind()).asFloatBuffer();  
	        while(fBuf.hasRemaining()) {  
	            System.out.print(fBuf.get()+",");  
	        }  
	}

}
