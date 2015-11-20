package com.yifutech.commom.dao;

import java.io.Serializable;

import com.yifutech.commom.model.SimpleEntity;

/**
 * 实体dao接口
 * @author brucey
 *
 * @param <PkType> 实体ID
 * @param <EntityType> 实体类型
 */
public interface SimpleEntityDao<PkType extends Serializable,EntityType extends SimpleEntity<PkType>> extends EntityDao<PkType, EntityType> {

}
