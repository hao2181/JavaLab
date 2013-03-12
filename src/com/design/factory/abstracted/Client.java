package com.design.factory.abstracted;

public class Client {
	//封装产品簇 抽象工厂模式 选择产品簇的实现 切换产品簇容易
	//实现接口和实现的分离
	//缺点：不太容易扩展新产品，容易造成类层次复杂
	//
	public static void main(String[] args) {
		AbstractDAOFactory adf = new XmlDAOFactory();
		OrderMainDAO mainDAO = adf.creatOrderMainDAO();
		OrderDetailDAO detailDAO = adf.creatOrderDetailDAO();
		mainDAO.saveOrderMain();
		detailDAO.saveOrderDetail();
	}
	
}
