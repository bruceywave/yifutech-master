package com.yifutech.commom.model.enums;

/**
 * 启用/禁用枚举
 * @author brucey
 *
 */
public enum Status {
	STATUS_ENABLE("启用"),STATUS_DISABLE("禁用");
	private final String value;
	
	private Status(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
