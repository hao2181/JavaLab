package com.design.factory.method;

public class ExportDbFileApi implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("导出DB文件"+data);
		return true;
	}

}
