package com.design.factory.method;

public abstract class Creator {
	
	public abstract ExportFileApi factoryMethod();
	
	public boolean export(String data){
		ExportFileApi api = factoryMethod();
		return api.export(data);
	} 
}
