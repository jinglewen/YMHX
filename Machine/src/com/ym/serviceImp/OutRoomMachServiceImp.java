package com.ym.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ym.daoImp.OutRoomMachDaoImp;
import com.ym.entity.MMach;
import com.ym.entity.MOutroommach;
import com.ym.entity.MProductmach;
import com.ym.entity.TTerminalmaintain;
import com.ym.service.Service;
@org.springframework.stereotype.Service
public class OutRoomMachServiceImp implements Service<MOutroommach>{

	@Autowired
	public OutRoomMachDaoImp outRoomMachDaoImp;
	
	@Override
	public void Add(MOutroommach t) {
		// TODO Auto-generated method stub
		outRoomMachDaoImp.Add(t);
	}

	@Override
	public void Update(MOutroommach t) {
		// TODO Auto-generated method stub
		outRoomMachDaoImp.Update(t);
	}

	//更新MMach
	public void UpdateMMach(MMach t){
		outRoomMachDaoImp.UpdateMMach(t);
	}
	//更新MproductMach
	public void UpdateMProduct(MProductmach t){
		outRoomMachDaoImp.UpdateMProduct(t);
	}
	//更新TTerminalmaintain
	public void UpdateTTer(TTerminalmaintain t){
		outRoomMachDaoImp.UpdateTTer(t);
	}
	
	@Override
	public void Deletee(MOutroommach t) {
		// TODO Auto-generated method stub
		outRoomMachDaoImp.Deletee(t);
	}

	@Override
	public MOutroommach SelectById(int id) {
		// TODO Auto-generated method stub
		return outRoomMachDaoImp.SelectById(id);
	}

	@Override
	public List<MOutroommach> SelectAll() {
		// TODO Auto-generated method stub
		return outRoomMachDaoImp.SelectAll();
	}

	@Override
	public List<MOutroommach> SelectByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return outRoomMachDaoImp.SelectByPage(pageIndex, pageSize);
	}

	@Override
	public List<MOutroommach> SelectByParm(MOutroommach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MOutroommach> SelectByPageParm(int pageIndex, int pageSize,
			MOutroommach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MOutroommach> SelectByParmTime(MOutroommach t, String starttime, String endtime){
		return outRoomMachDaoImp.SelectByParmTime(t, starttime, endtime);
	}
	
	public List<MOutroommach> SelectByPageParmTime(int pageIndex, int pageSize,
			MOutroommach t, String starttime, String endtime){
		return outRoomMachDaoImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
	}
	//根据箱子编号查询MOutroommach
	public List<MOutroommach> SelectOutByBoxNum(String boxnum){
		return outRoomMachDaoImp.SelectOutByBoxNum(boxnum);
	}
	//根据箱子编号查询箱子设备TTerminalmaintain
	public List<TTerminalmaintain> SelectByBoxNum(String boxnum){
		return outRoomMachDaoImp.SelectByBoxNum(boxnum);
	}
	//根据设备序列号查询设备MProductmach
	public MProductmach SelectBySerNum(String sernum){
		return outRoomMachDaoImp.SelectBySerNum(sernum);
	}
	//根据设备序列号查询MOutroommach
	public MOutroommach SelectOutBySerNum(String sernum){
		return outRoomMachDaoImp.SelectOutBySerNum(sernum);
	}
	//根据设备序列号查询MMach
	public MMach SelectMachBySerNum(String sernum){
		return outRoomMachDaoImp.SelectMachBySerNum(sernum);
	}

	@Override
	public void saveOrUpdate(List<MOutroommach> t) {
		// TODO Auto-generated method stub
		
	}
}
