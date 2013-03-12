package com.test.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import org.junit.Test;

public class FileLockTest1 {

	@Test
	// your java app lock file, then other software (e.g. notepad) can't modify
	// and save the locked file
	public void test1() {
		File f = new File("c:\\22.xls");
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(f, "rw");
			FileChannel fc = raf.getChannel();
			FileLock fl = fc.tryLock();
			System.out.println("locked");
			if (fl.isValid()) {
				// do something here, use notepad to modify and try to save the
				// 10. // lock file, Fail! 11. Thread.sleep(10000);
				fl.release();
				System.out.println("release lock");
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	//When another software (e.g. Excel) lock a file, if your java app try to lock it, will throw FileNotFoundException
	public void test2() {

		// before run this class, you must use excel to open e:\test.csv first,
		// because excel can lock file 2. File f = new File(filename);
		RandomAccessFile raf = null;

		System.out.println("**************Test lock method************");
		try {
			raf = new RandomAccessFile("c:\\22.xls", "rw");
			FileChannel fc = raf.getChannel();
			FileLock fl = fc.lock();
			System.out.println("locked");
			if (fl.isValid()) {
				fl.release();
				System.out.println("release lock");
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (raf != null)
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		System.out.println("**************Test tryLock method************");
		try {
			raf = new RandomAccessFile("c:\\22.xls", "rw");
			FileChannel fc = raf.getChannel();
			FileLock fl = fc.tryLock();
			System.out.println("locked");
			if (fl.isValid()) {
				fl.release();
				System.out.println("release lock");
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (raf != null)
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	
	// if you try to lock file  more than once in same thread or different thread, it will throw OverlappingFileLockException

	@Test
	public void testInSameThread() {
		System.out
				.println("*********************Test lock in the same thread***************");
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {
			raf1 = new RandomAccessFile("c:\\22.xls", "rw");
			FileChannel fc1 = raf1.getChannel();

			raf2 = new RandomAccessFile("c:\\22.xls", "rw");
			FileChannel fc2 = raf2.getChannel();

			System.out.println("Grabbing first lock");
			fc1.lock();

			System.out.println("Grabbing second lock");
			fc2.tryLock();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf1 != null)
					raf1.close();
				if (raf2 != null)
					raf2.close();
			} catch (Exception e) {
			}
		}
		System.out.println("Exiting");

	}
	
	@Test
	public void testInDiffThread() throws IOException {
		System.out.println("*********************Test lock in the different thread***************");
		RandomAccessFile raf1 = new RandomAccessFile("c:\\22.xls", "rw");
		FileChannel fc1 = raf1.getChannel();
		System.out.println("Grabbing first lock");
		fc1.lock();
		new Thread() {
			public void run() {
				RandomAccessFile raf2;
				try {
					raf2 = new RandomAccessFile("c:\\22.xls", "rw");
					FileChannel fc2 = raf2.getChannel();
					System.out.println("Grabbing second lock");
					fc2.tryLock();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		System.out.println("Done");
	}
	
	
	
	@Test
	public void TryLockReturnNullAndLockBlockDemoStep1(){
		       String fileName="c:\\22.xls";
		        try {
		            RandomAccessFile r = new RandomAccessFile(fileName, "rw");
		            FileChannel channel = r.getChannel();
		            FileLock fl = channel.tryLock();
		            System.out.println("FileLock obj is valid? " + fl.isValid());
		            Thread.sleep(10000);
		            System.out.println("release lock");
		            channel.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		       } catch (InterruptedException e) {
		            e.printStackTrace();
		       }

	}
	
	
	@Test
	/**
	 * !!NOTE: before run TryLockReturnNullAndLockBlockDemoStep2, you must run
	 * TryLockReturnNullAndLockBlockDemoStep1 first
	 * 
	 * this class is used to test when one JVM is locking a file, what happen when
	 * try to call tryLock/Lock method in another JVM
	 * 
	 * following codes show that:
	 * 
	 * 1. when u call tryLock method, the method return (return value is null)
	 * immediately
	 * 
	 * 2. when u call Lock method, the method will block until
	 * TryLockReturnNullAndLockBlockDemoStep1 release lock (after 30 secconds)
	 * 
	 */
	public void TryLockReturnNullAndLockBlockDemoStep2() {

		try {
			RandomAccessFile r = new RandomAccessFile("c:\\22.xls", "rw");
			FileChannel channel = r.getChannel();

			System.out.println("calling tryLock method...");
			FileLock f1 = channel.tryLock();
			System.out.println("tryLock return value is null?  " + (f1 == null));
			System.out.println("calling Lock method... (it will block until TryLockReturnNullAndLockBlockDemoStep1 release lock (after 30 secconds)");
			FileLock f2 = channel.lock();
			System.out.println("lock method is not blocked");
			System.out.println("lock return value is null?  " + (f2 == null));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testlock(){
		TryLockReturnNullAndLockBlockDemoStep1();
		TryLockReturnNullAndLockBlockDemoStep2();
	}
	
	@Test
	public void test2lock() throws IOException{
		RandomAccessFile r = new RandomAccessFile("c:\\22.xls", "rw");
		FileChannel channel = r.getChannel();
		FileLock f1 = channel.lock(0, 12, true);
		FileLock f2= channel.lock(13,20,false);
		System.out.println(f1.isShared()+"----"+f1.isValid());
		System.out.println(f2.isShared()+"----"+f2.isValid());
	}
}