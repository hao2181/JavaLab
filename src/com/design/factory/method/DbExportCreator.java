package com.design.factory.method;

public class DbExportCreator extends Creator {

	@Override
	public ExportFileApi factoryMethod() {
		
		return new ExportDbFileApi();
		
	}

}
