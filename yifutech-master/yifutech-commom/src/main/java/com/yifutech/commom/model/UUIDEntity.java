package com.yifutech.commom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 定义UUID基类,主要负责生成字符串UUID 32位
 * @author brucey
 *
 * @param <PkType>
 */
@MappedSuperclass //作用就是和继承它的实体生成同一张表
public class UUIDEntity<PkType extends Serializable> extends IdGenerator<PkType> {
	/**
	 * 主键唯一ID
	 */
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	@Column(columnDefinition="VARCHAR(32) COMMENT='主键ID'")
	private PkType id;
	@Override
	public void setId(PkType id) {
		this.id = id;
	}

	@Override
	public PkType getId() {
		return this.id;
	}

}
