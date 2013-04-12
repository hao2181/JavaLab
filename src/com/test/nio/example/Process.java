/**
 * 
 */
package com.test.nio.example;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author ZhangHao 
 * @date  2013-4-10
 */
public class Process implements Runnable {
	
	private SelectionKey key ;
	private Selector selector;
	protected ByteBuffer buffer = ByteBuffer.allocate(1024);
	protected CharsetDecoder decoder;
	static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();
	static String name;
	public Process() {
	}
	
	

	public Process(SelectionKey key,Selector selector) {
		this.key = key;
		this.selector = selector;
		Charset charset = Charset.forName("GB2312");
		decoder =  charset.newDecoder();
	}

	@Override
	public void run() {
		try{
			if(key.isAcceptable()){
				ServerSocketChannel server = (ServerSocketChannel)key.channel();
				SocketChannel channel = server.accept();
				channel.configureBlocking(false);
				channel.register(selector, SelectionKey.OP_READ);
			}else if(key.isReadable()){
				SocketChannel channel = (SocketChannel) key.channel();
				int count = channel.read(buffer);
				if(count > 0){
					buffer.flip();
					CharBuffer charBuffer = decoder.decode(buffer);
					name = charBuffer.toString();
					SelectionKey sKey = channel.register(selector,SelectionKey.OP_WRITE);
					sKey.attach(name);
				}else{
					channel.close();
				}
			}else if(key.isWritable()){
				SocketChannel channel = (SocketChannel) key.channel();
				channel.write(buffer);
				String name = (String) key.attachment();
				ByteBuffer block = encoder.encode(CharBuffer.wrap("Hello !" + name));
				channel.write(block);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
