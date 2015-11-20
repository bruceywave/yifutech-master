package com.yifutech.commom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.yifutech.commom.model.enums.Status;

/**
 * 启用/禁用
 * @author brucey
 *
 * @param <PkType> 主键类型，string
 */
@MappedSuperclass
public class EnableEntity<PkType extends Serializable> extends UUIDEntity<PkType>{
	
	/**
	 * 启用/禁用
	 */
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="VARCAHR(20) COMMENT='STATUS_ENABLE-启用,STATUS_DISABLE-禁用'")
	private Status enable = Status.STATUS_ENABLE;

	public Status getEnable() {
		return enable;
	}

	public void setEnable(Status enable) {
		this.enable = enable;
	}
}
