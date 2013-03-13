package com.test.xc.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestFailFast {

		public static void main(String[] args) {
			/**
			 * java.util.concurrent 集合返回的迭代器称为弱一致的（weakly consistent）迭代器。
			 * 对于这些类，如果元素自从迭代开始已经删除，且尚未由 next() 方法返回，那么它将不返回到调用者。
			 * 如果元素自迭代开始已经添加，那么它可能返回调用者，也可能不返回。
			 * 在一次迭代中，无论如何更改底层集合，元素不会被返回两次。
			 * 
			 */			
			Map<Integer,String> gradeMap = new ConcurrentHashMap<Integer, String>(); //弱一致迭代

			/**
			 * Fail-Fast迭代器  迭代器指向的是对象的单链表  
			 * 对象被改变后 迭代不到就会爆出 ConcurrentModificationException 
			 */
			//Map<Integer,String> gradeMap = Collections.synchronizedMap(new HashMap<Integer, String>());
			
			gradeMap.put(1, "1");
			gradeMap.put(2, "2");
			gradeMap.put(3, "3");
			gradeMap.put(4, "4");
			
			Iterator<Integer> keys = gradeMap.keySet().iterator();
	        while(keys.hasNext()){
	            Integer i = keys.next();
	           // keys.remove();
	            gradeMap.remove(i);
	        }
		}
}
