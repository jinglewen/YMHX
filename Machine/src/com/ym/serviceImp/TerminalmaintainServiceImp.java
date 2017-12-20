package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.TerminalmaintainDaoImp;
import com.ym.entity.TTerminalmaintain;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class TerminalmaintainServiceImp implements Service<TTerminalmaintain>{

	@Autowired
	public TerminalmaintainDaoImp terminalmaintainDaoImp;
	
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
		return terminalmaintainDaoImp.SelectAll();
	}

	@Override
	public List<TTerminalmaintain> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return terminalmaintainDaoImp.SelectByPage(pageIndex, pageSize);
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
		return terminalmaintainDaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<TTerminalmaintain> SelectByPageParmTime(int pageIndex, int pageSize, TTerminalmaintain t, String starttime, String endtime){
		return terminalmaintainDaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}

	@Override
	public void saveOrUpdate(List<TTerminalmaintain> t) {
		// TODO Auto-generated method stub
		
	}
}
