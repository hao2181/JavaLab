package com.design.strategy.log_template;

public class LogContext {
	
/*	private LogStrategy ls;
	
	public LogContext(LogStrategy ls){
		this.ls = ls;
	}*/
	/**
	 * 容错处理 如果存储到数据库失败 则存储在文件中
	 */
	public void log(String msg){
		LogStrategy ls = new DbLog();
		try{
			ls.doLog(msg);
		}catch(Exception e){
			ls = new FileLog();
			ls.doLog(msg);
		}
	}
}
