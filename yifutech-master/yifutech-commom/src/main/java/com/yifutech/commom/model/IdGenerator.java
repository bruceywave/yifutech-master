package com.yifutech.commom.model;

import java.io.Serializable;

/**
 * ID生成接口
 * @author brucey
 *
 * @param <PkType>
 */
public abstract class IdGenerator<PkType extends Serializable> {
	/**
	 * 设置ID
	 * @param id
	 */
	public abstract void setId(PkType id);
	
	/**
	 * 获取ID
	 * @return
	 */
	public abstract PkType getId();
	
}
