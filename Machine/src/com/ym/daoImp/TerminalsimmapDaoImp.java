package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.TTerminalsimmap;
@Repository
public class TerminalsimmapDaoImp implements Dao<TTerminalsimmap>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(TTerminalsimmap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TTerminalsimmap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TTerminalsimmap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TTerminalsimmap SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TTerminalsimmap> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from TTerminalsimmap";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<TTerminalsimmap> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from TTerminalsimmap where 1=1 ";
		int start = (pageIndex - 1)*pageSize;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<TTerminalsimmap> SelectByParm(TTerminalsimmap t) {
		// TODO Auto-generated method stub
		String hql = " from TTerminalsimmap where 1=1 ";
		if(t.getTerminalNo().length() > 0){
			hql += " and terminalNo like :terminalNo";
		}
		if(t.getSimno().length() > 0){
			hql += " and simno like :simno";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getTerminalNo().length() > 0){
			query.setParameter("terminalNo", "%"+t.getTerminalNo()+"%");
		}
		if(t.getSimno().length() > 0){
			query.setParameter("simno", "%"+t.getSimno()+"%");
		}
		return query.list();
	}

	@Override
	public List<TTerminalsimmap> SelectByPageParm(int pageIndex, int pageSize,
			TTerminalsimmap t) {
		// TODO Auto-generated method stub
		String hql = " from TTerminalsimmap where 1=1 ";
		if(t.getTerminalNo().length() > 0){
			hql += " and terminalNo like :terminalNo";
		}
		if(t.getSimno().length() > 0){
			hql += " and simno like :simno";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getTerminalNo().length() > 0){
			query.setParameter("terminalNo", "%"+t.getTerminalNo()+"%");
		}
		if(t.getSimno().length() > 0){
			query.setParameter("simno", "%"+t.getSimno()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public void saveOrUpdate(TTerminalsimmap t) {
		// TODO Auto-generated method stub
		
	}

}
