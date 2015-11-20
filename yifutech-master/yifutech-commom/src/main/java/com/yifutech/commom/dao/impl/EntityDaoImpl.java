package com.yifutech.commom.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yifutech.commom.dao.EntityDao;
import com.yifutech.commom.model.UUIDEntity;

@SuppressWarnings("all")
public abstract class EntityDaoImpl<PkType extends Serializable,EntityType extends UUIDEntity<PkType>> implements EntityDao<PkType, EntityType>{
	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Class<EntityType> entityClass;
	
	public EntityDaoImpl() {
		this.entityClass = (Class<EntityType>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(EntityType entity) {
		this.getSession().save(entity);
	}

	@Override
	public void update(EntityType entity) {
		this.getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(EntityType entity) {
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(EntityType entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void delete(PkType id) {
		String hql = "delete from " + entityClass.getSimpleName() + " where id=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@Override
	public EntityType findOne(PkType id) {
		return this.getSession().get(entityClass, id);
	}

	@Override
	public EntityType findOne(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityType findOne(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityType> queryForList(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityType> queryForList(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return 0;
	}

}
