package com.test.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

/**
 * @Title NIOTTest.java
 * @description TODO
 * @author qinpeng
 * @date Aug 25, 2009 10:23:26 PM
 */
public class MemoryMapping {

	public static void main(String[] args) {

		String fileName = "D:\\360云盘\\书籍\\未分类\\Hadoop.pdf";

		System.out.println("inputStream");
		long start = System.currentTimeMillis();
		long crcValue = checksumMappedFile(fileName);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + "耗时");

/*		System.out.println("BufferedinputStream");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(fileName);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + "耗时");

		System.out.println("RandomAccessFileinputStream");
		start = System.currentTimeMillis();
		crcValue = checksumRondomAccessFileInputStream(fileName);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + "耗时");

		System.out.println(" MappedFile inputStream");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(fileName);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + "耗时");*/
	}

	public static long checksumInputStreanm(String fileName) {
		CRC32 crc = new CRC32();
		try {
			InputStream in = new FileInputStream(fileName);
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err
					.print("NIOTTest--checksumInputStreanm--new FileInputStream is not found");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err
					.print("NIOTTest--checksumInputStreanm--new FileInputStream'read append IOException");
		}
		return crc.getValue();
	}

	public static long checksumBufferedInputStream(String fileName) {
		CRC32 crc = new CRC32();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					fileName));
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err
					.print("NIOTTest--checksumBufferedInputStream--new FileInputStream is not found");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err
					.print("NIOTTest--checksumBufferedInputStream--new FileInputStream'read append IOException");
		}
		return crc.getValue();
	}

	public static long checksumRondomAccessFileInputStream(String fileName) {
		CRC32 crc = new CRC32();
		try {
			RandomAccessFile file = new RandomAccessFile(fileName, "r");
			int c;
			while ((c = file.read()) != -1) {
				crc.update(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err
					.print("NIOTTest--checksumRondomAccessFileInputStream--new FileInputStream is not found");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err
					.print("NIOTTest--checksumRondomAccessFileInputStream--new FileInputStream'read append IOException");
		}
		return crc.getValue();
	}

	public static long checksumMappedFile(String fileName) {
		CRC32 crc = new CRC32();
		try {
			FileInputStream in = new FileInputStream(fileName);
			FileChannel channel = in.getChannel();
			int length = (int) channel.size();
			System.out.println(length);
			MappedByteBuffer buffer = channel.map(
					FileChannel.MapMode.READ_ONLY, 0, length);

			for (int p = 0; p < length; p++) {
				int c = buffer.getInt(p);
				crc.update(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err
					.print("NIOTTest--checksumRondomAccessFileInputStream--new FileInputStream is not found");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err
					.print("NIOTTest--checksumRondomAccessFileInputStream--new FileInputStream'read append IOException");
		}
		return crc.getValue();
	}

}
