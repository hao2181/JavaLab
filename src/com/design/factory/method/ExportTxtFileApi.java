package com.design.factory.method;

public class ExportTxtFileApi implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("导出TXT文件"+data);
		return true;
	}

}
