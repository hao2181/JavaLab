package com.test.nio;

import java.nio.ByteBuffer; 
import java.nio.channels.FileChannel; 
import java.io.File; 
import java.io.RandomAccessFile; 
import java.io.IOException; 
/**  
  * Create a file with holes in it 
  *  
  * @author Ron Hitchens (ron@ronsoft.com) 
  */ 


//文件空洞究竟是什么？ 
 
//当磁盘上一个文件的分配空间小于它的文件大小时会出现“文件空洞”。对于内容稀疏的文
//件，大多数现代文件系统只为实际写入的数据分配磁盘空间（更准确地说，只为那些写入数
//据的文件系统页分配空间）。假如数据被写入到文件中非连续的位置上，这将导致文件出现
//在逻辑上不包含数据的区域（即“空洞”）。例如，下面的代码可能产生一个如图 3-8 所示的文
//件： 
public class FileHole 
{ 
             public static void main (String [] argv) 
             throws IOException  
             {  
                          // Create a temp file, open for writing, and get  
                          // a FileChannel 
                          File temp = File.createTempFile ("holy", null); 
                          RandomAccessFile file = new RandomAccessFile (temp, "rw");  
                          FileChannel channel = file.getChannel( );  
                          // Create a working buffer 
                          ByteBuffer byteBuffer = ByteBuffer.allocateDirect (100); 
                          putData (0, byteBuffer, channel);  
                          putData (5000000, byteBuffer, channel); 
                          putData (50000, byteBuffer, channel); 
                          // Size will report the largest position written, but  
                          // there are two holes in this file. This file will 
                          // not consume 5 MB on disk (unless the filesystem is  
 
 
                          // extremely brain -damaged)  
                          System.out.println ("Wrote temp file '" + temp.getPath( ) 
                                      + "', size=" + channel.size( )); 
                          channel.close( ); 
                          file.close( ); 
             }  
             private static void putData (int position, ByteBuffer buffer,  
                          FileChannel channel) 
                          throws IOException  
             {  
                          String string = "*<-- location " + position; 
                          buffer.clear( ); 
                          buffer.put (string.getBytes ("US-ASCII")); 
                          buffer.flip( );  
                          channel.position (position);  
                          channel.write (buffer);  
             }  
} 
 
//如果该文件被顺序读取的话，所有空洞都会被“0”填充但不占用磁盘空间。读取该文件的
//进程会看到 5,000,021 个字节，大部分字节都以“0”表示。试试在该文件上运行strings 命令，看
//看您会得到什么。再试试将文件大小的值提高到 50 或100MB，看看您的全部磁盘空间消耗以
//及顺序扫描该文件所需时间会发生何种变化（前者不会改变，但是后者将有非常大的增
//加）。 