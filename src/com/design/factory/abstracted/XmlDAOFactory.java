package com.design.factory.abstracted;

public class XmlDAOFactory implements AbstractDAOFactory {

	@Override
	public OrderMainDAO creatOrderMainDAO() {
		return new XmlMainDAOImpl();
	}

	@Override
	public OrderDetailDAO creatOrderDetailDAO() {
		return new XmlDetailImpl();
	}

}
