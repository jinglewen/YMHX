package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.ImportInfo;

@Repository
public class ImportExcelDaoImp implements Dao<ImportInfo> {
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void Add(ImportInfo t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Update(ImportInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(ImportInfo t) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ImportInfo> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from ImportInfo";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<ImportInfo> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from ImportInfo where 1=1 ";
		int start = (pageIndex - 1)*pageSize;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<ImportInfo> SelectByParm(ImportInfo t) {
		String hql = " from ImportInfo where 1=1 ";
		if(t.getTid() != null){
			hql += " and tid like :tid";
		}
		if(t.getTsim() != null){
			hql += " and tsim like :tsim";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getTid() != null){
			query.setParameter("tid", "%"+t.getTid()+"%");
		}
		if(t.getTsim() != null){
			query.setParameter("tsim", "%"+t.getTsim()+"%");
		}
		return query.list();
	}

	@Override
	public List<ImportInfo> SelectByPageParm(int pageIndex, int pageSize,
			ImportInfo t) {
		String hql = " from ImportInfo where 1=1 ";
		if(t.getTid() != null){
			hql += " and tid like :tid";
		}
		if(t.getTsim() != null){
			hql += " and tsim like :tsim";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getTid() != null){
			query.setParameter("tid", "%"+t.getTid()+"%");
		}
		if(t.getTsim() != null){
			query.setParameter("tsim", "%"+t.getTsim()+"%");
		}
		int start = (pageIndex -1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public ImportInfo SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(ImportInfo t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);;
		session.flush();
		session.clear();
	}

	
}
