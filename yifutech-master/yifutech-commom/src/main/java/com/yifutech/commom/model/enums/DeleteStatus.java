package com.yifutech.commom.model.enums;


public enum DeleteStatus {
	DELETE_YES("已删除"),DELETE_NO("未删除");
	private final String value;
	
	private DeleteStatus(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
	
	
}
