package com.design.prototype.manager;

public interface Prototype {
    public Prototype clone();
    public String getName();
    public void setName(String name);
}