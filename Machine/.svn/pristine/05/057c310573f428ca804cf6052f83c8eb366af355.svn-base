package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.ImportExcelDaoImp;
import com.ym.entity.ImportInfo;
import com.ym.service.Service;

@org.springframework.stereotype.Service
public class ImportExcelServiceImp implements Service<ImportInfo>{

	@Autowired
	public ImportExcelDaoImp importExcelDaoImp;

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
		importExcelDaoImp.Deletee(t);
	}

	@Override
	public ImportInfo SelectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImportInfo> SelectAll() {
		// TODO Auto-generated method stub
		return importExcelDaoImp.SelectAll();
	}

	@Override
	public List<ImportInfo> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return importExcelDaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<ImportInfo> SelectByParm(ImportInfo t) {
		// TODO Auto-generated method stub
		return importExcelDaoImp.SelectByParm(t);
	}

	@Override
	public List<ImportInfo> SelectByPageParm(int pageIndex, int pageSize,
			ImportInfo t) {
		// TODO Auto-generated method stub
		return importExcelDaoImp.SelectByPageParm(pageIndex, pageSize, t);
	}

	@Override
	public void saveOrUpdate(List<ImportInfo> t) {
		// TODO Auto-generated method stub
		for (ImportInfo importInfo : t) {
			importExcelDaoImp.saveOrUpdate(importInfo);
		}
	}

}
