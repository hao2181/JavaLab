package com.zhang.test;

import java.nio.CharBuffer;

import org.junit.Test;

public class TestDemo {
	@Test
	public void testFirst(){
		System.out.println("Hello Junit");
	}
	
	@Test
	public void testDFnumber(){
/*		double d=15.12345678987654321;
		float f = 13.2f;
		double df = 15.3f;
		float f1 = 13.1234567891f;
		float f2 = 12.1234567891f;
		System.out.println(d);
		System.out.println(f1-f2);
		System.out.println(df);*/
		double d1 = 0.05;
		double d2 = 0.01;
		System.out.println(d1+d2);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
	}
	
	
	@Test
	public void testBuffer(){
		char [] myArray = new char [100]; 
		CharBuffer charbuffer = CharBuffer.wrap (myArray,2,12); 
		charbuffer.put('C');
		charbuffer.put('C');
		charbuffer.put('C');
		System.out.println(charbuffer.remaining());
		System.out.println(myArray[0]);
		System.out.println(charbuffer.hasArray());
		System.out.println(charbuffer.array()[0]);
		System.out.println(charbuffer.slice().length());
		//charbuffer.position(2);
		System.out.println(charbuffer.arrayOffset());
	}
	
	@Test
	public void testBufferCopy(){
		CharBuffer buffer = CharBuffer.allocate (8);  
		buffer.position (3).limit (6).mark().position (5);  
		CharBuffer dupeBuffer = buffer.duplicate(  );  
		buffer.put('a');
		System.out.println(dupeBuffer.position());
		
		System.out.println(dupeBuffer.position(5));
		dupeBuffer.put(5, 'm');
		System.out.println(buffer.position(5));
	}
	
}
