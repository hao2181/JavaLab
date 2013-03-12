package com.test.mina2;

import java.util.Scanner;

public class RunClient {
	public static void main(String[] args) {
		MinaClient client = new MinaClient();
		if (client.connect()) {
			client.send("连接服务器成功!");
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) {
				client.send(scanner.next());
			}
		}

	}

}