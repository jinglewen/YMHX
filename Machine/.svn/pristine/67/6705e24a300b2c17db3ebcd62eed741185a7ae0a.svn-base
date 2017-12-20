package com.ym.service;

import java.util.List;

public interface Service<T> {

	//添加
	void Add(T t);
	//批量添加
	void saveOrUpdate(List<T> t);
	//更新
	void Update(T t);
	//删除
	void Deletee(T t);
	//根据Id查询
	T SelectById(int id);
	//查询总数
	List<T> SelectAll();
	//分页查询
	List<T> SelectByPage(int pageIndex, int pageSize);
	//条件查询
	List<T> SelectByParm(T t);
	//条件分页查询
	List<T> SelectByPageParm(int pageIndex, int pageSize, T t);
	
}
