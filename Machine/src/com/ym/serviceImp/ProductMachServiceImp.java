package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.ProductMachDaoImp;
import com.ym.entity.MProductmach;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class ProductMachServiceImp implements Service<MProductmach>{

	@Autowired
	public ProductMachDaoImp productMachDaoImp;
	
	@Override
	public void Add(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(MProductmach t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MProductmach SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MProductmach> SelectAll() {
		// TODO Auto-generated method stub
		return productMachDaoImp.SelectAll();
	}

	@Override
	public List<MProductmach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return productMachDaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<MProductmach> SelectByParm(MProductmach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MProductmach> SelectByPageParm(int pageIndex, int pageSize,
			MProductmach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MProductmach> SelectByParmTime(MProductmach t, String starttime, String endtime){
		return productMachDaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<MProductmach> SelectByPageParmTime(int pageIndex, int pageSize, MProductmach t, String starttime, String endtime){
		return productMachDaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}

	@Override
	public void saveOrUpdate(List<MProductmach> t) {
		// TODO Auto-generated method stub
		
	}
}
