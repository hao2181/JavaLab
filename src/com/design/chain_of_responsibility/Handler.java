package com.design.chain_of_responsibility;

/**
 * 定义职责连的抽象接口 持有自己对象的引用
 * @author ZhangHao 
 * @date  2013-3-20
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;
    /**
     * 设置下一个处理请求的对象
     * @param successor 下一个处理请求的对象
     */
    public void setSuccessor(Handler successor){
       this.successor = successor;
    }
    /**
     * 处理聚餐费用的申请
     * @param user 申请人
     * @param fee 申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user,double fee);
}