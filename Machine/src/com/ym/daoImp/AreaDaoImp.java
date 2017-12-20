package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.UArea;
@Repository
public class AreaDaoImp implements Dao<UArea>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(UArea t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		session.flush();
	}

	@Override
	public void Update(UArea t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}

	@Override
	public void Deletee(UArea t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.SelectById(t.getId()));
		session.flush();
	}

	@Override
	public UArea SelectById(int id) {
		// TODO Auto-generated method stub
		String hql = " from UArea where 1=1 and id = "+id+"";
		Session session = sessionFactory.getCurrentSession();
		if(id > 0){
			return (UArea) session.createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}

	@Override
	public List<UArea> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from UArea";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<UArea> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from UArea where 1=1 ";
		hql += " order by id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<UArea> SelectByParm(UArea t) {
		// TODO Auto-generated method stub
		String hql = " from UArea where 1=1 ";
		if(t.getAreaName().length() > 0){
			hql += " and areaName like :areaName";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getAreaName().length() > 0){
			query.setParameter("areaName", "%"+t.getAreaName()+"%");
		}
		return query.list();
	}

	@Override
	public List<UArea> SelectByPageParm(int pageIndex, int pageSize, UArea t) {
		// TODO Auto-generated method stub
		String hql = " from UArea where 1=1 ";
		if(t.getAreaName().length() > 0){
			hql += " and areaName like :areaName";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getAreaName().length() > 0){
			query.setParameter("areaName", "%"+t.getAreaName()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public void saveOrUpdate(UArea t) {
		// TODO Auto-generated method stub
		
	}

}
