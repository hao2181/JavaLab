package com.test.xc;

public class AAAAA{

    public  boolean  enable = true; // [b]非violate[/b]

    // 线程A执行
    public void methodA(){
        while(enable){
            System.out.println("MethodA");
        }
        System.out.println("----------------------");
    }

    // 线程B执行
    public void methodB(){
        enable = false;
        System.out.println("---------BBBBBBBBBBBBBBBBBBBBBBB-------------");
    }
}
