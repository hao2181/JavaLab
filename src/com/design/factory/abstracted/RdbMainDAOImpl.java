package com.design.factory.abstracted;

public class RdbMainDAOImpl implements OrderMainDAO {

	@Override
	public void saveOrderMain() {
		System.out.println("RDB模式保存Main");
	}

}
