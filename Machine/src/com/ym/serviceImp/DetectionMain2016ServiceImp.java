package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.DetectionMain2016DaoImp;
import com.ym.entity.TDetectionItem2016;
import com.ym.entity.TDetectionMain2016;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class DetectionMain2016ServiceImp implements Service<TDetectionMain2016>{

	@Autowired
	public DetectionMain2016DaoImp detectionMain2016DaoImp;
	
	@Override
	public void Add(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TDetectionMain2016 SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2016> SelectAll() {
		// TODO Auto-generated method stub
		return detectionMain2016DaoImp.SelectAll();
	}

	@Override
	public List<TDetectionMain2016> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return detectionMain2016DaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<TDetectionMain2016> SelectByParm(TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2016> SelectByPageParm(int pageIndex,
			int pageSize, TDetectionMain2016 t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TDetectionMain2016> SelectByParmTime(TDetectionMain2016 t, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return detectionMain2016DaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<TDetectionMain2016> SelectByPageParmTime(int pageIndex,
			int pageSize, TDetectionMain2016 t, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return detectionMain2016DaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}
	
	//根据detectionMainId查询DetectionItem2016
	public List<TDetectionItem2016> SelectItem2016ById(String detectionMainId){
		return detectionMain2016DaoImp.SelectItem2016ById(detectionMainId);
	}
	
	//根据detectionMainId查询DetectionItem2016(Fail)
	public List<TDetectionItem2016> SelectItem2016FailById(String detectionMainId){
		return detectionMain2016DaoImp.SelectItem2016FailById(detectionMainId);
	}

	@Override
	public void saveOrUpdate(List<TDetectionMain2016> t) {
		// TODO Auto-generated method stub
		
	}
}
