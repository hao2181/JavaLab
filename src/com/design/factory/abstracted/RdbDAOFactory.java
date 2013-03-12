package com.design.factory.abstracted;

public class RdbDAOFactory implements AbstractDAOFactory {

	@Override
	public OrderMainDAO creatOrderMainDAO() {
		return new RdbMainDAOImpl();
	}

	@Override
	public OrderDetailDAO creatOrderDetailDAO() {
		return new RdbDetailImpl();
	}

}
