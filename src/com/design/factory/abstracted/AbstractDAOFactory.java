package com.design.factory.abstracted;

public interface AbstractDAOFactory {
	
	public OrderMainDAO creatOrderMainDAO();
	
	public OrderDetailDAO creatOrderDetailDAO();
	
}
