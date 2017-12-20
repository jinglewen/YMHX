package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.MProductmach;
@Repository
public class ProductMachDaoImp implements Dao<MProductmach>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MProductmach SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MProductmach> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from MProductmach where 1=1 ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<MProductmach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from MProductmach where 1=1 ";
		hql += " order by productDate desc";
		int start = (pageIndex - 1)*pageSize;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<MProductmach> SelectByParm(MProductmach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MProductmach> SelectByPageParm(int pageIndex, int pageSize,
			MProductmach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MProductmach> SelectByParmTime(MProductmach t, String starttime, String endtime){
		String hql = " from MProductmach where 1=1 ";
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
		}
		if(t.getOperator().length() > 0){
			hql += " and operator like :operator";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and productDate between '"+starttime+"' and '"+endtime+"'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getSerNumber().length() > 0){
			query.setParameter("serNumber", "%"+t.getSerNumber()+"%");
		}
		if(t.getMachName().length() > 0){
			query.setParameter("machName", "%"+t.getMachName()+"%");
		}
		if(t.getMachState().length() > 0){
			query.setParameter("machState", "%"+t.getMachState()+"%");
		}
		if(t.getOperator().length() > 0){
			query.setParameter("operator", "%"+t.getOperator()+"%");
		}
		return query.list();
	}
	
	public List<MProductmach> SelectByPageParmTime(int pageIndex, int pageSize,
			   MProductmach t, String starttime, String endtime){
		String hql = " from MProductmach where 1=1 ";
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
		}
		if(t.getOperator().length() > 0){
			hql += " and operator like :operator";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and productDate between '"+starttime+"' and '"+endtime+"'";
		}
		hql += " order by productDate desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getSerNumber().length() > 0){
			query.setParameter("serNumber", "%"+t.getSerNumber()+"%");
		}
		if(t.getMachName().length() > 0){
			query.setParameter("machName", "%"+t.getMachName()+"%");
		}
		if(t.getMachState().length() > 0){
			query.setParameter("machState", "%"+t.getMachState()+"%");
		}
		if(t.getOperator().length() > 0){
			query.setParameter("operator", "%"+t.getOperator()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public void saveOrUpdate(MProductmach t) {
		// TODO Auto-generated method stub
		
	}
}
