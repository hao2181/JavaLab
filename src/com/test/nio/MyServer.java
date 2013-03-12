package com.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Nio服务端
 * @author ZhangHao
 * @date  2012-11-30
 */
public class MyServer {

	private int port;
	private Selector selector;
	private ByteBuffer buffer = ByteBuffer.allocate(1204);
	public  MyServer(int port){
		this.port = port;
		try {
			selector = this.getSelector(port);
			System.out.println("Sever Started!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Selector getSelector(int port) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		Selector sel = Selector.open();
		server.socket().bind(new InetSocketAddress(port));//fuck 
		server.configureBlocking(false); //设置非阻塞
		server.register(sel, SelectionKey.OP_ACCEPT);
		return sel;
	}
	public static void main(String[] args) throws IOException {
		MyServer server = new MyServer(9999);
		server.listen();
	}

	private void listen() throws IOException {
		while(true){
			selector.select();
			Iterator iter = selector.selectedKeys().iterator();
			while(iter.hasNext()){
				SelectionKey key = (SelectionKey)iter.next();
				iter.remove();
				process(key);
			}
		}
	}
	
	private void process(SelectionKey key) throws IOException {
		if(key.isAcceptable()){
			ServerSocketChannel server = (ServerSocketChannel)key.channel();
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
		}else if(key.isReadable()){
			SocketChannel channel = (SocketChannel) key.channel();
			if(channel.read(buffer)>0){
				buffer.flip();
				System.out.println(buffer.toString());
				buffer.clear();
				channel.register(selector, SelectionKey.OP_WRITE, "zhanghao");
			};
		}else if(key.isWritable()){
			SocketChannel channel = (SocketChannel) key.channel();
			String name = (String)key.attachment();
			ByteBuffer msg = ByteBuffer.wrap(name.getBytes());
			channel.write(msg);
			channel.close();
		}
	}

}
