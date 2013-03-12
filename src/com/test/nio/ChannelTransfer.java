package com.test.nio;

import java.io.FileInputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransfer

{
	public static void main(String[] argv) throws Exception {
		if (argv.length == 0) {
			System.err.println("Usage: filename ...");
			return;
		}
		catFiles(Channels.newChannel(System.out), argv);
	}

	private static void catFiles(WritableByteChannel target, String[] files)
			throws Exception {
		for (int i = 0; i < files.length; i++) {
			FileInputStream fis = new FileInputStream(files[i]);
			FileChannel channel = fis.getChannel();
			channel.transferTo(0, channel.size(), target);
			channel.close();
			fis.close();
		}
	}
}