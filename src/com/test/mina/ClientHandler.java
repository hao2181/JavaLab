package com.test.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler extends IoHandlerAdapter{
    @Override
    /**
     * 客户端接收服务端发来的信息
     */
    public void messageReceived(IoSession session, Object message) throws Exception
    {
        System.out.println("接收的服务端信息:"+message.toString());// 显示接收到的消息
    }

}
