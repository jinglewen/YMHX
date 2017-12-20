package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.TDetectionItem2017;
import com.ym.entity.TDetectionMain2017;
@Repository
public class DetectionMain2017DaoImp implements Dao<TDetectionMain2017>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TDetectionMain2017 SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2017> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from TDetectionMain2017 where 1=1 and length(batchNumber) > 10 ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<TDetectionMain2017> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from TDetectionMain2017 where 1=1 and length(batchNumber) > 10 ";
		hql += " order by creationTime desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<TDetectionMain2017> SelectByParm(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2017> SelectByPageParm(int pageIndex,
			int pageSize, TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TDetectionMain2017> SelectByParmTime(TDetectionMain2017 t, String starttime, String endtime){
		String hql = " from TDetectionMain2017 where 1=1 and length(batchNumber) > 10 ";
		if(t.getBatchNumber().length() > 0){
			hql += " and batchNumber like :batchNumber";
		}
		if(t.getDetectionType() != 0){
			hql += " and detectionType = :detectionType";
		}
		if(t.getResult().length() > 1){
			hql += " and result like :result";
		}
		if(t.getTerminalModel().length() > 0){
			hql += " and terminalModel = :terminalModel";
		}
		if(t.getCreaterRealName().length() > 0){
			hql += " and createrRealName = :createrRealName";
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
		if(t.getTerminalModel().length() > 0){
			query.setParameter("terminalModel", t.getTerminalModel());
		}
		if(t.getCreaterRealName().length() > 0){
			query.setParameter("createrRealName", t.getCreaterRealName());
		}
		return query.list();
	}
	
	public List<TDetectionMain2017> SelectByPageParmTime(int pageIndex, int pageSize,
			TDetectionMain2017 t, String starttime, String endtime){
		String hql = " from TDetectionMain2017 where 1=1 and length(batchNumber) > 10 ";
		if(t.getBatchNumber().length() > 0){
			hql += " and batchNumber like :batchNumber";
		}
		if(t.getDetectionType() != 0){
			hql += " and detectionType = :detectionType";
		}
		if(t.getResult().length() > 1){
			hql += " and result like :result";
		}
		if(t.getTerminalModel().length() > 0){
			hql += " and terminalModel = :terminalModel";
		}
		if(t.getCreaterRealName().length() > 0){
			hql += " and createrRealName = :createrRealName";
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
		if(t.getTerminalModel().length() > 0){
			query.setParameter("terminalModel", t.getTerminalModel());
		}
		if(t.getCreaterRealName().length() > 0){
			query.setParameter("createrRealName", t.getCreaterRealName());
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}
		
	//根据detectionMainId查询DetectionItem2017
	public List<TDetectionItem2017> SelectItem2017ById(String detectionMainId){
		String hql = " from TDetectionItem2017 where 1=1 and detectionMainId = '"+detectionMainId+"'";
		if(detectionMainId.length() > 10){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}
	
	//根据detectionMainId查询DetectionItem2017(Fail)
	public List<TDetectionItem2017> SelectItem2017FailById(String detectionMainId){
		String hql = " from TDetectionItem2017 where 1=1 and detectionMainId = '"+detectionMainId+"' and result like '%Fail%' ";
		if(detectionMainId.length() > 10){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}

	@Override
	public void saveOrUpdate(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}
}
