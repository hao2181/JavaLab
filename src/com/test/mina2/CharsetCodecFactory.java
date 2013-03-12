package com.test.mina2;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class CharsetCodecFactory  implements ProtocolCodecFactory{

	public ProtocolDecoder getDecoder(IoSession iosession) throws Exception {
		return new CharsetDecoder();
	}

	public ProtocolEncoder getEncoder(IoSession iosession) throws Exception {
		return new CharsetEncoder();
	}
}
