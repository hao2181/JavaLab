package com.design.strategy.log_template;

public class FileLog extends LogStrategyTemplate{
	
    public void log(String msg) {
    	
       System.out.println("现在把 '"+msg+"' 记录到文件中");
       
    }
}
