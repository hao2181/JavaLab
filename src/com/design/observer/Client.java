/**
 * 
 */
package com.design.observer;

/**
 * @author zhanghao
 * 定义对象间的一对多的依赖关系，
 * 当一个对象的状态发生改变时所有依赖与他的对象都会得到通知
 */
public class Client {
    public static void main(String[] args) {
       //创建一个报纸，作为被观察者
       NewsPaper subject = new NewsPaper();
       //创建阅读者，也就是观察者
       Reader reader1 = new Reader();
       reader1.setName("张三");
 
       Reader reader2 = new Reader();
       reader2.setName("李四");
 
       Reader reader3 = new Reader();
       reader3.setName("王五");
 
       //注册阅读者
       subject.attach(reader1);
       subject.attach(reader2);
       subject.attach(reader3);
       subject.detach(reader1);
 
       //要出报纸啦
       subject.setContent("本期内容是观察者模式");
    }
}