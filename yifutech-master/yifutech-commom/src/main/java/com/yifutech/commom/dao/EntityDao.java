package com.yifutech.commom.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.yifutech.commom.model.UUIDEntity;

public interface EntityDao<PkType extends Serializable,EntityType extends UUIDEntity<PkType>>{
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(EntityType entity);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(EntityType entity);
	
	/**
	 * 保存或者更新实体
	 * @param entity
	 */
	void saveOrUpdate(EntityType entity);
	
	/**
	 * 删除实体
	 * @param entity
	 */
	void delete(EntityType entity);
	
	/**
	 * 通过ID删除实体 
	 * @param id
	 */
	void delete(PkType id);
	
	/**
	 * 根据ID查询唯一实体
	 * @param id
	 * @return
	 */
	EntityType findOne(PkType id);
	
	/**
	 * 根据hql 参数查询
	 * @param hql hql语句
	 * @param params  查询参数 支持  o.del=:deleteParams  map<deleteParams,deleteParamValues>
	 * @return
	 */
	EntityType findOne(String hql,Map<String, Object> params);
	
	/**
	 * 根据hql 参数查询
	 * @param hql hql语句
	 * @param params 参数  支持 o.del = ?    new Object[]{deleteParamValue}
	 * @return
	 */
	EntityType findOne(String hql,Object...params);
	
	/**
	 * 查询所有的集合
	 * @return
	 */
	List<EntityType> findAll();
	
	/**
	 * 根据hql 组合查询列表
	 * @param hql
	 * @param params
	 * @return
	 */
	List<EntityType> queryForList(String hql,Map<String, Object> params);
	
	/**
	 * 根据hql组合查询
	 * @param hql
	 * @param params
	 * @return
	 */
	List<EntityType> queryForList(String hql,Object...params);
	
	/**
	 * 查询总记录数
	 * @param hql
	 * @param params
	 * @return
	 */
	long count(String hql,Map<String, Object> params);
	
	/**
	 * 查询总记录数
	 * @param hql
	 * @param objects
	 * @return
	 */
	long count(String hql,Object...objects);
}
