package com.yifutech.commom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用于类似组织机构，资源管理等树形结构的表
 * @author brucey
 *
 * @param <PkType>
 * @param <Entity>
 */
@MappedSuperclass
public class ChainEntity<PkType extends Serializable,Entity extends UUIDEntity<PkType>> extends EnableEntity<PkType> implements Comparable<Entity>{
	private String iconCls; //图标
	private String levelCode; //级别码
	@Column(name="description",length=500)
	private String description; //描述
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Entity parent;  //上级
	
	private int priority = 9999; //数字越小，优先级越高
	
	@JsonIgnore
	@OneToMany(mappedBy="parent",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	private List<Entity> children = new ArrayList<Entity>(0); //所有的孩子

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Entity getParent() {
		return parent;
	}

	public void setParent(Entity parent) {
		this.parent = parent;
	}

	public List<Entity> getChildren() {
		return children;
	}

	public void setChildren(List<Entity> children) {
		this.children = children;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(Entity o) {
		if (o == null) {
			return -1;
		} else if (o == this) {
			return 0;
		} else if (this.priority <  ((ChainEntity) o).getPriority()) {
			return -1;
		} else if (this.priority > ((ChainEntity) o).getPriority()) {
			return 1;
		}
		return 0;
	}
}
