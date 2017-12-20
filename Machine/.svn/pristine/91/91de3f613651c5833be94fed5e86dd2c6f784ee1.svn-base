package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.TDetectionItem2016;
import com.ym.entity.TDetectionMain2016;
@Repository
public class DetectionMain2016DaoImp implements Dao<TDetectionMain2016>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TDetectionMain2016 SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2016> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from TDetectionMain2016 where 1=1 and length(batchNumber) > 10 ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<TDetectionMain2016> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from TDetectionMain2016 where 1=1 and length(batchNumber) > 10 ";
		hql += " order by creationTime desc";
		int start = (pageIndex - 1)*pageSize;
		return sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<TDetectionMain2016> SelectByParm(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2016> SelectByPageParm(int pageIndex,
			int pageSize, TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<TDetectionMain2016> SelectByParmTime(TDetectionMain2016 t, String starttime, String endtime){
		String hql = " from TDetectionMain2016 where 1=1 and length(batchNumber) > 10 ";
		if(t.getBatchNumber().length() > 0){
			hql += " and batchNumber like :batchNumber";
		}
		if(t.getDetectionType() != 0){
			hql += " and detectionType = :detectionType";
		}
		if(t.getResult().length() > 1){
			hql += " and result like :result";
		}
		if(starttime.length() > 1 && endtime.length() > 1){
			hql += " and creationTime between '"+starttime+"' and '"+endtime+"'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBatchNumber().length() > 0){
			query.setParameter("batchNumber", "%"+t.getBatchNumber()+"%");
		}
		if(t.getDetectionType() != 0){
			query.setParameter("detectionType", t.getDetectionType());
		}
		if(t.getResult().length() > 1){
			query.setParameter("result", "%"+t.getResult()+"%");
		}
		return query.list();
	}
	
	public List<TDetectionMain2016> SelectByPageParmTime(int pageIndex, int pageSize,
			TDetectionMain2016 t, String starttime, String endtime){
		String hql = " from TDetectionMain2016 where 1=1 and length(batchNumber) > 10 ";
		if(t.getBatchNumber().length() > 0){
			hql += " and batchNumber like :batchNumber";
		}
		if(t.getDetectionType() != 0){
			hql += " and detectionType = :detectionType";
		}
		if(t.getResult().length() > 1){
			hql += " and result like :result";
		}
		if(starttime.length() > 1 && endtime.length() > 1){
			hql += " and creationTime between '"+starttime+"' and '"+endtime+"'";
		}
		hql += " order by creationTime desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBatchNumber().length() > 0){
			query.setParameter("batchNumber", "%"+t.getBatchNumber()+"%");
		}
		if(t.getDetectionType() != 0){
			query.setParameter("detectionType", t.getDetectionType());
		}
		if(t.getResult().length() > 1){
			query.setParameter("result", "%"+t.getResult()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}
		
	//根据detectionMainId查询DetectionItem2016
	public List<TDetectionItem2016> SelectItem2016ById(String detectionMainId){
		String hql = " from TDetectionItem2016 where 1=1 and detectionMainId = '"+detectionMainId+"'";
		if(detectionMainId.length() > 10){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}

	//根据detectionMainId查询DetectionItem2016(Fail)
	public List<TDetectionItem2016> SelectItem2016FailById(String detectionMainId){
		String hql = " from TDetectionItem2016 where 1=1 and detectionMainId = '"+detectionMainId+"' and result like '%Fail%' ";
		if(detectionMainId.length() > 10){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}

	@Override
	public void saveOrUpdate(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}
	
}
