/**
 * 
 */
package com.test.io;

import java.io.Serializable;

/**
 * @author zhanghao
 *
 */
public class Person implements Serializable{  
    public Person(){  
 
    }  
 
    public Person(String name, int age){  
        this.name = name;  
        this.age = age;  
    }  
 
    @Override 
    public String toString(){  
        return "������" + name + "  ���䣺" + age;  
    }  
 
    private String name;  
    private int age;  
}  
