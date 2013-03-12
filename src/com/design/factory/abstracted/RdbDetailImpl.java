package com.design.factory.abstracted;

public class RdbDetailImpl implements OrderDetailDAO {

	@Override
	public void saveOrderDetail() {
		System.out.println("RDB模式保存DETAIL");

	}

}
