package com.utils;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlType;

/**
 * @ClassName: Constants
 * @Description: 常量类
 * @author 
 * @date 2011-12-28
 * @version V1.0
 */
@XmlType(propOrder={})
public final class Constants {

	private Constants() {
	}

	public static Map<String, String> loadSqlMap = new HashMap<String, String>(
			16);
	
	
}