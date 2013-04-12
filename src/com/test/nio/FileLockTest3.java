/**
 * 
 */
package com.test.nio;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest3 {
public static void main(String[] args) {

     FileLockTest3 nf1 = new FileLockTest3();
     nf1.getLock();
   

}

public void getLock(){
 try {
  RandomAccessFile raf = new RandomAccessFile("D:\\test\\test2\\NioMemory_mapped.txt", "rw");
     FileChannel fc = raf.getChannel();
     System.out.println( "将要获得文件锁" );
     //FileLock lock = fc.lock(0,raf.length(),true); //共享锁，不阻塞共享锁的获取
     FileLock lock = fc.lock();  //排它锁，阻塞所有锁的获取
      System.out.println( "获得文件锁" );
      Thread.sleep(30000);
      lock.release();
      System.out.println( "释放文件锁" );
 } catch (Exception e) {
  // TODO: handle exception
 }
 
}

public void getLock2(){
 try {
  RandomAccessFile raf = new RandomAccessFile("D:\\test\\test2\\NioMemory_mapped.txt", "rw");
     FileChannel fc = raf.getChannel();
     System.out.println( "logck2将要获得文件锁" );
     //FileLock lock = fc.lock(0,raf.length(),true); //共享锁，不阻塞共享锁的获取
   FileLock lock = fc.lock();  //排它锁，阻塞所有锁的获取
      System.out.println( "logck2获得文件锁" );
      Thread.sleep(5000);
      lock.release();
      System.out.println( "logck2释放文件锁" );
 } catch (Exception e) {
  // TODO: handle exception
 }
}
}