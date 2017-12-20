package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ym.daoImp.UserinfoDaoImp;
import com.ym.entity.UFunction;
import com.ym.entity.UUserfunrelation;
import com.ym.entity.UUserinfo;
import com.ym.service.UserinfoService;
@Service
public class UserinfoServiceImp implements UserinfoService<UUserinfo>{

	@Autowired
	public UserinfoDaoImp userinfoDaoImp;
	
	@Override
	public void Add(UUserinfo t) {
		// TODO Auto-generated method stub
		userinfoDaoImp.Add(t);
	}

	@Override
	public void Update(UUserinfo t) {
		// TODO Auto-generated method stub
		userinfoDaoImp.Update(t);
	}

	@Override
	public void Deletee(UUserinfo t) {
		// TODO Auto-generated method stub
		userinfoDaoImp.Deletee(t);
	}

	@Override
	public List<UUserinfo> SelectAll() {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectAll();
	}

	@Override
	public List<UUserinfo> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<UUserinfo> SelectByParm(UUserinfo t) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectByParm(t);
	}

	@Override
	public List<UUserinfo> SelectByPageParm(int pageIndex, int pageSize,
			UUserinfo t) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectByPageParm(pageIndex, pageSize, t);
	}

	@Override
	public UUserinfo SelectByUserId(int userId) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectByUserId(userId);
	}

	@Override
	public UUserinfo SelectByUserName(String userName) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectByUserName(userName);
	}

	@Override
	public UUserinfo UserLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.UserLogin(userName, passWord);
	}

	@Override
	public List<UFunction> SelectFunByUserId(int userId) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectFunByUserId(userId);
	}

	@Override
	public List<UUserfunrelation> SelectUserFun(int userId) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectUserFun(userId);
	}

	@Override
	public UUserfunrelation SelectUserFunById(int id) {
		// TODO Auto-generated method stub
		return userinfoDaoImp.SelectUserFunById(id);
	}

	@Override
	public void DeleteUserFun(int Id) {
		// TODO Auto-generated method stub
		userinfoDaoImp.DeleteUserFun(Id);
	}

	@Override
	public void AddUserFun(UUserfunrelation uf) {
		// TODO Auto-generated method stub
		userinfoDaoImp.AddUserFun(uf);
	}


}
