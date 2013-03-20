/**
 * 
 */
package com.design.chain_of_responsibility;

/**
 * @author ZhangHao 
 * @date  2013-3-20
 * 
 * 一个抽象类 持有自身对象的引用
 * 
 * 
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间耦合
 * 将这些对象连成一个条，并沿着这条链传递该请求 知道有个对象处理它为止
 * 
 *JAVA中典型的职责连引用 异常就属于职责连范畴
 *
 *职责链模式的本质：分离职责，动态组合。
 */
public class Client {
    public static void main(String[] args) {
       //先要组装职责链   
       Handler h1 = new GeneralManager();
       Handler h2 = new DepManager();
       Handler h3 = new ProjectManager();
       h3.setSuccessor(h2);
       h2.setSuccessor(h1);
      
       //开始测试
       String ret1 = h3.handleFeeRequest("小李", 300);
       System.out.println("the ret1="+ret1); 
       String ret2 = h3.handleFeeRequest("小张", 300);
       System.out.println("the ret2="+ret2); 
      
       String ret3 = h3.handleFeeRequest("小李", 600);
       System.out.println("the ret3="+ret3); 
       String ret4 = h3.handleFeeRequest("小张", 600);
       System.out.println("the ret4="+ret4); 
      
       String ret5 = h3.handleFeeRequest("小李", 1200); 
       System.out.println("the ret5="+ret5); 
       String ret6 = h3.handleFeeRequest("小张", 1200);
       System.out.println("the ret6="+ret6); 
    }
}