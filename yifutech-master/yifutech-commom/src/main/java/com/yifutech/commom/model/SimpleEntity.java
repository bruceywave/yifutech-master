package com.yifutech.commom.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 简单的实体类
 * @author brucey
 *
 * @param <PkType>
 */
@MappedSuperclass
public class SimpleEntity<PkType extends Serializable> extends UUIDEntity<PkType> {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
