package com.yifutech.commom.dao.impl;

import java.io.Serializable;

import com.yifutech.commom.dao.SimpleEntityDao;
import com.yifutech.commom.model.SimpleEntity;

public abstract class SimpleEntityDaoImpl<PkType extends Serializable,EntityType extends SimpleEntity<PkType>> extends EntityDaoImpl<PkType, EntityType> implements SimpleEntityDao<PkType,EntityType> {

}
