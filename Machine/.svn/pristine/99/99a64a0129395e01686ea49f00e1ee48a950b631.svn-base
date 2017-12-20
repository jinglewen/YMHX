package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.Dao;
import com.ym.entity.MMach;
import com.ym.entity.MOutroommach;
import com.ym.entity.MProductmach;
import com.ym.entity.TTerminalmaintain;
@Repository
public class OutRoomMachDaoImp implements Dao<MOutroommach>{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(MOutroommach t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		session.flush();
	}

	@Override
	public void Update(MOutroommach t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}

	//更新MMach
	public void UpdateMMach(MMach t){
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}
	//更新MproductMach
	public void UpdateMProduct(MProductmach t){
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}
	//更新TTerminalmaintain
	public void UpdateTTer(TTerminalmaintain t){
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}
	
	@Override
	public void Deletee(MOutroommach t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.SelectById(t.getId()));
		session.flush();
	}

	@Override
	public MOutroommach SelectById(int id) {
		// TODO Auto-generated method stub
		String hql = " from MOutroommach where 1=1 and id = "+id+"";
		if(id > 0){
			return (MOutroommach) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}
		
	}

	@Override
	public List<MOutroommach> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from MOutroommach where 1=1 ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<MOutroommach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from MOutroommach where 1=1 ";
		hql += " group by boxNumber,serNumber order by outRoomDate desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<MOutroommach> SelectByParm(MOutroommach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MOutroommach> SelectByPageParm(int pageIndex, int pageSize,
			MOutroommach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MOutroommach> SelectByParmTime(MOutroommach t, String starttime, String endtime){
		String hql = " from MOutroommach where 1=1 ";
		if(t.getBoxNumber().length() > 0){
			hql += " and boxNumber like :boxNumber";
		}
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
		}
		if(t.getOutRoomNumber().length() > 0){
			hql += " and outRoomNumber like :outRoomNumber";
		}
		if(t.getCustomerName().length() > 0){
			hql += " and customerName like :customerName";
		}
		if(t.getCustomerCompany().length() > 0){
			hql += " and customerCompany like :customerCompany";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and outRoomDate between '"+starttime+"' and '"+endtime+"'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBoxNumber().length() > 0){
			query.setParameter("boxNumber", "%"+t.getBoxNumber()+"%");
		}
		if(t.getSerNumber().length() > 0){
			query.setParameter("serNumber", "%"+t.getSerNumber()+"%");
		}
		if(t.getMachName().length() > 0){
			query.setParameter("machName", "%"+t.getMachName()+"%");
		}
		if(t.getMachState().length() > 0){
			query.setParameter("machState", "%"+t.getMachState()+"%");
		}
		if(t.getOutRoomNumber().length() > 0){
			query.setParameter("outRoomNumber", "%"+t.getOutRoomNumber()+"%");
		}
		if(t.getCustomerName().length() > 0){
			query.setParameter("customerName", "%"+t.getCustomerName()+"%");
		}
		if(t.getCustomerCompany().length() > 0){
			query.setParameter("customerCompany", "%"+t.getCustomerCompany()+"%");
		}
		return query.list();
	}
	
	public List<MOutroommach> SelectByPageParmTime(int pageIndex, int pageSize,
			MOutroommach t, String starttime, String endtime){
		String hql = " from MOutroommach where 1=1 ";
		if(t.getBoxNumber().length() > 0){
			hql += " and boxNumber like :boxNumber";
		}
		if(t.getSerNumber().length() > 0){
			hql += " and serNumber like :serNumber";
		}
		if(t.getMachName().length() > 0){
			hql += " and machName like :machName";
		}
		if(t.getMachState().length() > 0){
			hql += " and machState like :machState";
		}
		if(t.getOutRoomNumber().length() > 0){
			hql += " and outRoomNumber like :outRoomNumber";
		}
		if(t.getCustomerName().length() > 0){
			hql += " and customerName like :customerName";
		}
		if(t.getCustomerCompany().length() > 0){
			hql += " and customerCompany like :customerCompany";
		}
		if(starttime.length() > 0 && endtime.length() > 0){
			hql += " and outRoomDate between '"+starttime+"' and '"+endtime+"'";
		}
		hql += " group by boxNumber,serNumber order by outRoomDate desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getBoxNumber().length() > 0){
			query.setParameter("boxNumber", "%"+t.getBoxNumber()+"%");
		}
		if(t.getSerNumber().length() > 0){
			query.setParameter("serNumber", "%"+t.getSerNumber()+"%");
		}
		if(t.getMachName().length() > 0){
			query.setParameter("machName", "%"+t.getMachName()+"%");
		}
		if(t.getMachState().length() > 0){
			query.setParameter("machState", "%"+t.getMachState()+"%");
		}
		if(t.getOutRoomNumber().length() > 0){
			query.setParameter("outRoomNumber", "%"+t.getOutRoomNumber()+"%");
		}
		if(t.getCustomerName().length() > 0){
			query.setParameter("customerName", "%"+t.getCustomerName()+"%");
		}
		if(t.getCustomerCompany().length() > 0){
			query.setParameter("customerCompany", "%"+t.getCustomerCompany()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}
	
	//根据箱子编号查询MOutroommach
	public List<MOutroommach> SelectOutByBoxNum(String boxnum){
		String hql = " from MOutroommach where 1=1 and boxNumber = '"+boxnum+"'";
		if(boxnum.length() > 0){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}
	
	//根据设备序列号查询MOutroommach
	public MOutroommach SelectOutBySerNum(String sernum){
		String hql = " from MOutroommach where 1=1 and serNumber = '"+sernum+"'";
		if(sernum.length() > 0){
			return (MOutroommach) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}
	
	//根据箱子编号查询箱子设备TTerminalmaintain
	public List<TTerminalmaintain> SelectByBoxNum(String boxnum){
		String hql = " from TTerminalmaintain where 1=1 and boxNumber = '"+boxnum+"' and wholeMachState = 0";
		if(boxnum.length() > 0){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}
	
	//根据设备序列号查询设备MProductmach
	public MProductmach SelectBySerNum(String sernum){
		String hql = " from MProductmach where 1=1 and serNumber = '"+sernum+"'";
		if(sernum.length() > 0){
			return (MProductmach) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}	
	}
	
	//根据设备序列号查询MMach
	public MMach SelectMachBySerNum(String sernum){
		String hql = " from MMach where 1=1 and serNumber = '"+sernum+"'";
		if(sernum.length() > 0){
			return (MMach) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}

	@Override
	public void saveOrUpdate(MOutroommach t) {
		// TODO Auto-generated method stub
		
	}
}
