package com.design.strategy.log_template;

public class DbLog extends LogStrategyTemplate {

	@Override
	public void log(String msg) {
		  //制造错误
	       if(msg!=null && msg.trim().length()>5){
	           int a = 5/0;
	       }
	       System.out.println("现在把 '"+msg+"' 记录到数据库中");
	}

}
