package com.test.mina2;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMessageHandlerAdapter extends IoHandlerAdapter {

	private final static Logger log = LoggerFactory
			.getLogger(ClientMessageHandlerAdapter.class);

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String content = message.toString();
		log.info("客户端收到服务器发来的消息: " + content);
	}

	public void messageSent(IoSession session, Object message) throws Exception {
		log.info("客户向服务端发送消息：" + message);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		log.info("服务器发生异常： {}", cause);
		//System.out.println();

	}

}