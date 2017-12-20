package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.TTerminalmaintain;
@Repository
public class TerminalmaintainDaoImp implements Dao<TTerminalmaintain>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(TTerminalmaintain t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TTerminalmaintain t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TTerminalmaintain t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TTerminalmaintain SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TTerminalmaintain> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from TTerminalmaintain where 1=1 ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<TTerminalmaintain> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from TTerminalmaintain where 1=1 ";
		hql += " group by boxNumber,wholeMachineId order by creationTime desc";
		int start = (pageIndex - 1)*pageSize;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<TTerminalmaintain> SelectByParm(TTerminalmaintain t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TTerminalmaintain> SelectByPageParm(int pageIndex,
			int pageSize, TTerminalmaintain t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TTerminalmaintain> SelectByParmTime(TTerminalmaintain t, String starttime, String endtime){
		String hql = " from TTerminalmaintain where 1=1 ";
		if(t.getBoxNumber().length() > 0){
			hql += " and boxNumber like :boxNumber";
		}
		if(t.getBoxState() != 2){
			hql += " and boxState = :boxState";
		}
		if(t.getWholeMachineId().length() > 0){
			hql += " and wholeMachineId like :wholeMachineId";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and modifyTime between '"+starttime+"' and '"+endtime+"'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBoxNumber().length() > 0){
			query.setParameter("boxNumber", "%"+t.getBoxNumber()+"%");
		}
		if(t.getBoxState() != 2){
			query.setParameter("boxState", t.getBoxState());
		}
		if(t.getWholeMachineId().length() > 0){
			query.setParameter("wholeMachineId", "%"+t.getWholeMachineId()+"%");
		}
		return query.list();
	}
	
	public List<TTerminalmaintain> SelectByPageParmTime(int pageIndex, int pageSize,
			TTerminalmaintain t, String starttime, String endtime){
		String hql = " from TTerminalmaintain where 1=1 ";
		if(t.getBoxNumber().length() > 0){
			hql += " and boxNumber like :boxNumber";
		}
		if(t.getBoxState() != 2){
			hql += " and boxState = :boxState";
		}
		if(t.getWholeMachineId().length() > 0){
			hql += " and wholeMachineId like :wholeMachineId";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and modifyTime between '"+starttime+"' and '"+endtime+"'";
		}
		hql += " group by boxNumber,wholeMachineId order by creationTime desc";
		//System.out.println("hql:"+hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBoxNumber().length() > 0){
			query.setParameter("boxNumber", "%"+t.getBoxNumber()+"%");
		}
		if(t.getBoxState() != 2){
			query.setParameter("boxState", t.getBoxState());
		}
		if(t.getWholeMachineId().length() > 0){
			query.setParameter("wholeMachineId", "%"+t.getWholeMachineId()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public void saveOrUpdate(TTerminalmaintain t) {
		// TODO Auto-generated method stub
		
	}
}
