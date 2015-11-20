package com.yifutech.commom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.yifutech.commom.model.enums.DeleteStatus;

/**
 * 实体类删除标记
 * @author brucey
 *
 * @param <PkType>
 */
@MappedSuperclass
public class DeleteEntity<PkType extends Serializable> extends EnableEntity<PkType>{
	/**
	 * 删除状态
	 */
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="VARCAHR(20) COMMENT='DELETE_NO-未删除，DELETE_YES-已删除'")
	private DeleteStatus del = DeleteStatus.DELETE_NO;

	public DeleteStatus getDel() {
		return del;
	}

	public void setDel(DeleteStatus del) {
		this.del = del;
	}
}
