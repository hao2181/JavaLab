/**
 * 
 */
package com.utils;

/**
 * @author ZhangHao 
 * @date  2013-5-18
 */
public class TestReadProperties {

	public static void main(String[] args) {
		LoadPopertiesFile.loadSqlFile("appliction.properties");
		System.out.println(Constants.loadSqlMap);
	}
}
