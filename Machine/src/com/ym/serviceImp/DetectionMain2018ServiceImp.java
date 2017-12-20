package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ym.daoImp.DetectionMain2018DaoImp;
import com.ym.entity.TDetectionItem2018;
import com.ym.entity.TDetectionMain2018;

@Service
public class DetectionMain2018ServiceImp implements com.ym.service.Service<TDetectionMain2018>{

	@Autowired
	public DetectionMain2018DaoImp detectionMain2018DaoImp;
	
	@Override
	public void Add(TDetectionMain2018 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TDetectionMain2018 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TDetectionMain2018 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TDetectionMain2018 SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2018> SelectAll() {
		// TODO Auto-generated method stub
		return detectionMain2018DaoImp.SelectAll();
	}

	@Override
	public List<TDetectionMain2018> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return detectionMain2018DaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<TDetectionMain2018> SelectByParm(TDetectionMain2018 t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2018> SelectByPageParm(int pageIndex,
			int pageSize, TDetectionMain2018 t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TDetectionMain2018> SelectByParmTime(TDetectionMain2018 t, String starttime, String endtime){
		return detectionMain2018DaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<TDetectionMain2018> SelectByPageParmTime(int pageIndex, int pageSize, TDetectionMain2018 t, String starttime, String endtime){
		return detectionMain2018DaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}
	
	//根据detectionMainId查询DetectionItem2018
	public List<TDetectionItem2018> SelectItem2018ById(String detectionMainId){
		return detectionMain2018DaoImp.SelectItem2018ById(detectionMainId);
	}
	
	//根据detectionMainId查询DetectionItem2018(Fail)
	public List<TDetectionItem2018> SelectItem2018FailById(String detectionMainId){
		return detectionMain2018DaoImp.SelectItem2018FailById(detectionMainId);
	}

	@Override
	public void saveOrUpdate(List<TDetectionMain2018> t) {
		// TODO Auto-generated method stub
		
	}
}
