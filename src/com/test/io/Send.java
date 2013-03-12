/**
 * 
 */
package com.test.io;

import java.io.PipedOutputStream;

/**
 * @author zhanghao
 *
 */
public class Send implements Runnable{  
	    private PipedOutputStream out=null;  
	    public Send() {  
	        out=new PipedOutputStream();  
	    }  
	    public PipedOutputStream getOut(){  
	        return this.out;  
	    }  
	    public void run(){  
	        String message="hello , Rollen and Zhanghao";  
	        try{  
	            out.write(message.getBytes());  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }try{  
	            out.close();  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	}  

