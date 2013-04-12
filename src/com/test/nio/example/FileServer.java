/**
 * 
 */
package com.test.nio.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao 
 * @date  2013-4-10
 */
public class FileServer {

	protected Selector selector;


	static String name = "";

	public FileServer(int port) throws IOException {
		selector = this.getSelector(port);

	}

	private Selector getSelector(int port) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		Selector sel = Selector.open();
		server.socket().bind(new InetSocketAddress(port));
		server.configureBlocking(false);
		server.register(sel, SelectionKey.OP_ACCEPT);
		System.out.println("=========Server Started============");
		return sel;
	}

	private void start(ExecutorService threadpools) throws IOException {
		System.out.println("ssss");
		while(true){
			selector.select();
			System.out.println("=========zuse============");
			Iterator iter = selector.selectedKeys().iterator();
			while (iter.hasNext()) {
				SelectionKey key = (SelectionKey) iter.next();
				iter.remove();
				Process process = new Process(key,selector);
				threadpools.submit(process);
			}
			
		}
	}


	public static void main(String[] args) throws IOException {
		FileServer fs = new FileServer(1125);
		ExecutorService threadPools = Executors.newFixedThreadPool(10);
		fs.start(threadPools);
		
	}



	
	
}
