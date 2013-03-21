package com.design.mediator;
/**
 * 同事类
 * @author ZhangHao 
 * @date  2013-3-21
 */
public abstract class Colleague {
    private Mediator mediator;
    
    public Colleague(Mediator mediator) {
       this.mediator = mediator;
    }
    
    public Mediator getMediator() {
       return mediator;
    }
}