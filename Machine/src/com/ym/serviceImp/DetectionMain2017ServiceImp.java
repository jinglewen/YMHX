package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ym.daoImp.DetectionMain2017DaoImp;
import com.ym.entity.TDetectionItem2017;
import com.ym.entity.TDetectionMain2017;

@Service
public class DetectionMain2017ServiceImp implements com.ym.service.Service<TDetectionMain2017>{

	@Autowired
	public DetectionMain2017DaoImp detectionMain2017DaoImp;
	
	@Override
	public void Add(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletee(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TDetectionMain2017 SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2017> SelectAll() {
		// TODO Auto-generated method stub
		return detectionMain2017DaoImp.SelectAll();
	}

	@Override
	public List<TDetectionMain2017> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return detectionMain2017DaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<TDetectionMain2017> SelectByParm(TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TDetectionMain2017> SelectByPageParm(int pageIndex,
			int pageSize, TDetectionMain2017 t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TDetectionMain2017> SelectByParmTime(TDetectionMain2017 t, String starttime, String endtime){
		return detectionMain2017DaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<TDetectionMain2017> SelectByPageParmTime(int pageIndex, int pageSize, TDetectionMain2017 t, String starttime, String endtime){
		return detectionMain2017DaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}
	
	//根据detectionMainId查询DetectionItem2017
	public List<TDetectionItem2017> SelectItem2017ById(String detectionMainId){
		return detectionMain2017DaoImp.SelectItem2017ById(detectionMainId);
	}
	
	//根据detectionMainId查询DetectionItem2017(Fail)
	public List<TDetectionItem2017> SelectItem2017FailById(String detectionMainId){
		return detectionMain2017DaoImp.SelectItem2017FailById(detectionMainId);
	}

	@Override
	public void saveOrUpdate(List<TDetectionMain2017> t) {
		// TODO Auto-generated method stub
		
	}
}
