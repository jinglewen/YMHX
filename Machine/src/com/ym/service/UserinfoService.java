package com.ym.service;

import java.util.List;

import com.ym.entity.UFunction;
import com.ym.entity.UUserfunrelation;

public interface UserinfoService<T> {

	//添加
	void Add(T t);
	//更新
	void Update(T t);
	//删除
	void Deletee(T t);
	
	//根据userId查询(从用户功能表)
	List<UUserfunrelation> SelectUserFun(int userId);
	//根据Id查询(从用户功能表)
	UUserfunrelation SelectUserFunById(int id);
	//删除用户功能表用户权限
	void DeleteUserFun(int Id);
	//添加用户功能表用户权限
	void AddUserFun(UUserfunrelation uf);
	
	//查询总数
	List<T> SelectAll();
	//分页查询
	List<T> SelectByPage(int pageIndex, int pageSize);
	//条件查询总数
	List<T> SelectByParm(T t);
	//条件分页查询
	List<T> SelectByPageParm(int pageIndex, int pageSize, T t);
	//根据Id查找用户
	T SelectByUserId(int userId);
	//根据userName查找用户
	T SelectByUserName(String userName);
	//用户登录
	T UserLogin(String userName, String passWord);
	//根据userId查询用户权限
	List<UFunction> SelectFunByUserId(int userId);
	
}
