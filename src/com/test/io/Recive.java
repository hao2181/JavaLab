/**
 * 
 */
package com.test.io;

import java.io.PipedInputStream;

/**
 * @author zhanghao
 *
 */
/**  
 * ������Ϣ��  
 * */ 
public class Recive implements Runnable{  
    private PipedInputStream input=null;  
    public Recive(){  
        this.input=new PipedInputStream();  
    }  
    public PipedInputStream getInput(){  
        return this.input;  
    }  
    public void run(){  
        byte[] b=new byte[1000];  
        int len=0;  
        try{  
            len=this.input.read(b);  
        }catch (Exception e) {  
            e.printStackTrace();  
        }try{  
            input.close();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("���ܵ�����Ϊ "+(new String(b,0,len)));  
    }  
}  
