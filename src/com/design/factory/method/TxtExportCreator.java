package com.design.factory.method;

public class TxtExportCreator extends Creator {

	@Override
	public ExportFileApi factoryMethod() {
		
		return new ExportTxtFileApi();
		
	}

}
