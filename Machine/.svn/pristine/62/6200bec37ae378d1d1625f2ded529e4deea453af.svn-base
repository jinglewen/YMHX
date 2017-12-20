package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.AreaDaoImp;
import com.ym.entity.UArea;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class AreaServiceImp implements Service<UArea>{

	@Autowired
	public AreaDaoImp areaDaoImp;
	
	@Override
	public void Add(UArea t) {
		// TODO Auto-generated method stub
		areaDaoImp.Add(t);
	}

	@Override
	public void Update(UArea t) {
		// TODO Auto-generated method stub
		areaDaoImp.Update(t);
	}

	@Override
	public void Deletee(UArea t) {
		// TODO Auto-generated method stub
		areaDaoImp.Deletee(t);
	}

	@Override
	public UArea SelectById(int id) {
		// TODO Auto-generated method stub
		return areaDaoImp.SelectById(id);
	}

	@Override
	public List<UArea> SelectAll() {
		// TODO Auto-generated method stub
		return areaDaoImp.SelectAll();
	}

	@Override
	public List<UArea> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return areaDaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<UArea> SelectByParm(UArea t) {
		// TODO Auto-generated method stub
		return areaDaoImp.SelectByParm(t);
	}

	@Override
	public List<UArea> SelectByPageParm(int pageIndex, int pageSize, UArea t) {
		// TODO Auto-generated method stub
		return areaDaoImp.SelectByPageParm(pageIndex, pageSize, t);
	}

	@Override
	public void saveOrUpdate(List<UArea> t) {
		// TODO Auto-generated method stub
		
	}

}
