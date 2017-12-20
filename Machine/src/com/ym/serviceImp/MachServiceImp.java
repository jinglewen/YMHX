package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.MachDaoImp;
import com.ym.entity.MMach;
import com.ym.entity.MProductmach;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class MachServiceImp implements Service<MMach>{

	@Autowired
	public MachDaoImp machDaoImp;
	
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
		return machDaoImp.SelectAll();
	}

	@Override
	public List<MMach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return machDaoImp.SelectByPage(pageIndex, pageSize);
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
		return machDaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<MMach> SelectByPageParmTime(int pageIndex, int pageSize, MMach t, String starttime, String endtime){
		return machDaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}
	
	//根据serNumber查询生产机历史
	public List<MProductmach> SelectProBySerNum(String sernum){
		return machDaoImp.SelectProBySerNum(sernum);
	}

	@Override
	public void saveOrUpdate(List<MMach> t) {
		// TODO Auto-generated method stub
		
	}
}
