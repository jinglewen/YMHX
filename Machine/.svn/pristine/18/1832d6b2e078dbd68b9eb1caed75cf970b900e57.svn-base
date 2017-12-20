package com.ym.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ym.dao.UserinfoDao;
import com.ym.entity.UFunction;
import com.ym.entity.UUserfunrelation;
import com.ym.entity.UUserinfo;
@Repository
public class UserinfoDaoImp implements UserinfoDao<UUserinfo> {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void Add(UUserinfo t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		session.flush();
	}

	@Override
	public void Update(UUserinfo t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}

	@Override
	public void Deletee(UUserinfo t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.SelectByUserId(t.getId()));
		session.flush();
	}

	@Override
	public List<UUserinfo> SelectAll() {
		// TODO Auto-generated method stub
		String hql = " from UUserinfo ";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<UUserinfo> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from UUserinfo where 1=1 ";
		int start = (pageIndex - 1)*pageSize;
		return sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public List<UUserinfo> SelectByParm(UUserinfo t) {
		// TODO Auto-generated method stub
		String hql = " from UUserinfo where 1=1 ";
		if(t.getUserName() != null){
			hql += " and userName like :userName";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getUserName() != null){
			query.setParameter("userName", "%"+t.getUserName()+"%");
		}
		return query.list();
	}

	@Override
	public List<UUserinfo> SelectByPageParm(int pageIndex, int pageSize,
			UUserinfo t) {
		// TODO Auto-generated method stub
		String hql = " from UUserinfo where 1=1 ";
		if(t.getUserName() != null){
			hql += " and userName like :userName";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(t.getUserName() != null){
			query.setParameter("userName", "%"+t.getUserName()+"%");
		}
		int start = (pageIndex - 1)*pageSize;
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	//根据userId查询用户
	@Override
	public UUserinfo SelectByUserId(int userId){
		Session session = sessionFactory.getCurrentSession();
		String hql = " from UUserinfo where 1=1 and id = "+userId+"";
		if(userId > 0){			
			return (UUserinfo) session.createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}
	
	//根据用户名(UserName)查询用户
	@Override
	public UUserinfo SelectByUserName(String userName){
		String hql = " from UUserinfo where 1=1 and userName = '"+userName+"'";
		if(userName.length() > 0){
			return  (UUserinfo) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}
	
	//用户登录
	@Override
	public UUserinfo UserLogin(String username, String password){
		String hql = " from UUserinfo where 1=1 and userName = '"+username+"' and passWord = '"+password+"'";
		if(username.length() > 0 && password.length() > 0){
			return (UUserinfo) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}

	@Override
	public List<UFunction> SelectFunByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "from UFunction where id in (";
			   hql += "select funId from UUserfunrelation where userId = "+userId+")";
	    if(userId > 0){
		    return sessionFactory.getCurrentSession().createQuery(hql).list();
	    }else{
	    	return null;
	    }
	}

	
	//根据userId查询(从用户功能表)
	@Override
	public List<UUserfunrelation> SelectUserFun(int userId) {
		// TODO Auto-generated method stub
		String hql = " from UUserfunrelation where 1=1 and userId = "+userId+"";
		if(userId > 0){
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}else{
			return null;
		}
	}

	//根据Id查询(从用户功能表)
	@Override
	public UUserfunrelation SelectUserFunById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " from UUserfunrelation where 1=1 and id = "+id+"";
		if(id > 0){
			return (UUserfunrelation) session.createQuery(hql).uniqueResult();
		}else{
			return null;
		}
	}

	//删除用户功能表用户权限
	@Override
	public void DeleteUserFun(int Id) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.delete(this.SelectUserFunById(Id));
		session.flush();
	}

	//添加用户功能表用户权限
	@Override
	public void AddUserFun(UUserfunrelation uf) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.save(uf);
		session.flush();
	}
	
}
