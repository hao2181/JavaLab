package com.design.strategy.log_template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class LogStrategyTemplate implements LogStrategy {

	
	public final void doLog(String msg) {
		// 第一步：给消息添加记录日志的时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		msg = df.format(new java.util.Date()) + " 内容是：" + msg;
		// 第二步：真正执行日志记录
		log(msg);
	}
	
	protected abstract void log(String msg);
}
