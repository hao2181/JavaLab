package com.test.mina2;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class CharsetDecoder implements ProtocolDecoder  {
	
	private final static Charset charset = Charset.forName("UTF-8");  
	 // 可变的IoBuffer数据缓冲区   
	private IoBuffer buff = IoBuffer.allocate(100).setAutoExpand(true);
	
	public void decode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		
        // 如果有消息       
		while (in.hasRemaining()) {            
			   byte b = in.get();
			   if (b == '\n') {
				   buff.flip();               
				   byte[] bytes = new byte[buff.limit()];
				   buff.get(bytes);               
				   String message = new String(bytes, charset);
				   buff = IoBuffer.allocate(100).setAutoExpand(true);                               
				   // 如果结束了，就写入转码后的数据
				   out.write(message);
			   }else{
				   buff.put(b);
			   }
		}
		
	}

	public void dispose(IoSession iosession) throws Exception {
	}

	public void finishDecode(IoSession iosession,
			ProtocolDecoderOutput protocoldecoderoutput) throws Exception {
	}

	
}
