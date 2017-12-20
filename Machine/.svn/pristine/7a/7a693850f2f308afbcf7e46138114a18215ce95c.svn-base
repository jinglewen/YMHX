package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.MMach;
import com.ym.entity.MProductmach;
@Repository
public class MachDaoImp implements Dao<MMach>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(MMach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(MMach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(MMach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MMach SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MMach> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from MMach where 1=1";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<MMach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from MMach where 1=1";
		hql += " order by productDate desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<MMach> SelectByParm(MMach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MMach> SelectByPageParm(int pageIndex, int pageSize, MMach t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MMach> SelectByParmTime(MMach t, String starttime, String endtime){
		String hql = " from MMach where 1=1 ";
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
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
		return query.list();
	}
	
	public List<MMach> SelectByPageParmTime(int pageIndex, int pageSize, MMach t, String starttime, String endtime){
		String hql = " from MMach where 1=1";
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
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
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	//根据serNumber查询生产机历史
	public List<MProductmach> SelectProBySerNum(String sernum){
		String hql = " from MProductmach where 1=1 and serNumber = '"+sernum+"'";
		if(sernum.length() > 0){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}

	@Override
	public void saveOrUpdate(MMach t) {
		// TODO Auto-generated method stub
		
	}
}
