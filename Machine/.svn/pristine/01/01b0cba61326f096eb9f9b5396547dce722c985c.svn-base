package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ym.entity.MMach;
import com.ym.entity.MOutroommach;
import com.ym.entity.MProductmach;
import com.ym.entity.TTerminalmaintain;
import com.ym.entity.UUserinfo;
import com.ym.serviceImp.OutRoomMachServiceImp;
import com.ym.util.DateUtil;
import com.ym.util.PoiExcelExport;
import com.ym.util.PrintWriterUtil;

@Controller
public class OutRoomMachController {

	@Autowired
	public OutRoomMachServiceImp outRoomMachServiceImp;
	
	//分页查询
	@RequestMapping("/SelectOutRoomMachByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		//System.out.println("page-rows:"+pageIndex+"-"+pageSize);
		int total = outRoomMachServiceImp.SelectAll().size();
		List<MOutroommach> listbypage = outRoomMachServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件查询
	@RequestMapping("/SelectOutRoomMachByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, MOutroommach t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		//System.out.println("page:"+pageIndex+"-"+pageSize+"-"+starttime+"-"+endtime+"-"+t.getSerNumber()+"-"+t.getBoxNumber()+"-"+t.getMachName()+"-"+t.getMachState()+"-"+t.getCustomerName()+"-"+t.getOutRoomNumber()+"-"+t.getCustomerCompany());
		int total = outRoomMachServiceImp.SelectByParmTime(t, starttime, endtime).size();
		//System.out.println("total:"+total);
		List<MOutroommach> listbypageparm = outRoomMachServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
	//添加
	@RequestMapping("/AddOutRoomMach")
	public void Add(HttpServletRequest request, HttpServletResponse response, MOutroommach t){
		UUserinfo u = (UUserinfo) request.getSession().getAttribute("userinfo");
		String boxnum = t.getBoxNumber();
		Boolean flag = false;
		Map<String, Object> map = new HashMap<>();
		List<MOutroommach> molist = outRoomMachServiceImp.SelectOutByBoxNum(boxnum);
		if(molist.size() > 0){
			flag = true;
			map.put("ErrorCode", 6);//此箱子已发货
		}
		if(flag == false){
			List<TTerminalmaintain> terlist = outRoomMachServiceImp.SelectByBoxNum(boxnum);
			if(terlist.size() > 0){
				for(TTerminalmaintain tt : terlist){
					MProductmach mp = outRoomMachServiceImp.SelectBySerNum(tt.getWholeMachineId());
					if(mp == null){
						map.put("ErrorCode", 2);//此设备未生产
						map.put("mpMachName", tt.getWholeMachineId());
						flag = true;
					}
				}
				if(flag == false){
					for(TTerminalmaintain tt : terlist){
						MProductmach mpp = outRoomMachServiceImp.SelectBySerNum(tt.getWholeMachineId());
						MOutroommach mout = new MOutroommach();
						mout.setBoxNumber(tt.getBoxNumber());
						mout.setSerNumber(mpp.getSerNumber());
						mout.setMachName(mpp.getMachName());
						mout.setMachState("出货机");
						mout.setOutRoomNumber(t.getOutRoomNumber());
						mout.setOutRoomBatch(t.getOutRoomBatch());
						mout.setOutRoomAdress(t.getOutRoomAdress());
						mout.setOutRoomDate(t.getOutRoomDate());
						mout.setOutRoomUserName(t.getOutRoomUserName());
						mout.setOutRoomUserPhone(t.getOutRoomUserPhone());
						mout.setCustomerName(t.getCustomerName());
						mout.setCustomerPhone(t.getCustomerPhone());
						mout.setCustomerAdress(t.getCustomerAdress());
						mout.setCustomerCompany(t.getCustomerCompany());
						mout.setCustomerCompanyPhone(t.getCustomerCompanyPhone());
						mout.setOptionUser(u.getUserName());
						mout.setOptionTime(DateUtil.NowTime());
						mout.setIsDelete(0);
						mout.setProductDate(mpp.getProductDate());
						mout.setTerminalId(mpp.getTerminalId());
						mout.setPsModule(mpp.getPsModule());
						mout.setPhModule(mpp.getPhModule());
						mout.setHardwareversion(mpp.getHardwareversion());
						mout.setSoftwareversion(mpp.getSoftwareversion());
						//更新生产
//						mpp.setMachState("出货机");
//						outRoomMachServiceImp.UpdateMProduct(mpp);
						//更新所有设备
						MMach m = outRoomMachServiceImp.SelectMachBySerNum(tt.getWholeMachineId());
						m.setMachState("出货机");
						outRoomMachServiceImp.UpdateMMach(m);
						//更新装箱
						tt.setBoxState(1);
						outRoomMachServiceImp.UpdateTTer(tt);
						map.put("ErrorCode", 0);//添加成功
						outRoomMachServiceImp.Add(mout);
					}
				}
			}else{
				map.put("ErrorCode", 1);//此箱子无设备或不存在
			}
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//更新
	@RequestMapping("/UpdateOutRoomMach")
	public void Update(HttpServletRequest request, HttpServletResponse response, MOutroommach t){
		UUserinfo uu = (UUserinfo) request.getSession().getAttribute("userinfo");
		String boxnum = request.getParameter("boxnum");
		List<MOutroommach> outlist = outRoomMachServiceImp.SelectOutByBoxNum(boxnum);
		Map<String, Object> map = new HashMap<>();
		if(outlist.size() == 0){
			map.put("ErrorCode", 5);//箱子编号错误,更新失败
		}else{
			for(MOutroommach mo : outlist){
				//System.out.println("id:"+mo.getId());
				mo.setOutRoomDate(t.getOutRoomDate());
				mo.setOutRoomNumber(t.getOutRoomNumber());
				mo.setOutRoomBatch(t.getOutRoomBatch());
				mo.setOutRoomAdress(t.getOutRoomAdress());
				mo.setOutRoomUserName(t.getOutRoomUserName());
				mo.setOutRoomUserPhone(t.getOutRoomUserPhone());
				mo.setCustomerName(t.getCustomerName());
				mo.setCustomerPhone(t.getCustomerPhone());
				mo.setCustomerAdress(t.getCustomerAdress());
				mo.setCustomerCompany(t.getCustomerCompany());
				mo.setCustomerCompanyPhone(t.getCustomerCompanyPhone());
				mo.setOptionUser(uu.getUserName());
				outRoomMachServiceImp.Update(mo);
				map.put("ErrorCode", 4);//成功
			}
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//删除
	@RequestMapping("/DeleteOutRoomMach")
	public void Delete(HttpServletRequest request, HttpServletResponse response){
		String boxnum = request.getParameter("boxnum");
		List<MOutroommach> outlist = outRoomMachServiceImp.SelectOutByBoxNum(boxnum);
		Map<String, Object> map = new HashMap<>();
		if(outlist.size() == 0){
			map.put("ErrorCode", 1);//删除失败
		}else{
			//更新装箱
			List<TTerminalmaintain> ttrlist = outRoomMachServiceImp.SelectByBoxNum(boxnum);
			for(TTerminalmaintain ttr : ttrlist){
				ttr.setBoxState(0);
				outRoomMachServiceImp.UpdateTTer(ttr);
			}
			for(MOutroommach mo : outlist){
				//更新生产
//				MProductmach mp = outRoomMachServiceImp.SelectBySerNum(mo.getSerNumber());
//				if(mp != null){
//					mp.setMachState("生产机");
//					outRoomMachServiceImp.UpdateMProduct(mp);
//				}
				//更新所有设备
				MMach mm = outRoomMachServiceImp.SelectMachBySerNum(mo.getSerNumber());
				if(mm != null){
					mm.setMachState("生产机");
					outRoomMachServiceImp.UpdateMMach(mm);
				}
				outRoomMachServiceImp.Deletee(mo);
				map.put("ErrorCode", 0);//删除成功
			}
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//数据导出Excel
	@RequestMapping("/OutRoomMach_exportExcel")
	public void ExportExcel(HttpServletRequest request, HttpServletResponse response){
		String boxNumber = request.getParameter("boxNumber");
		String serNumber = request.getParameter("serNumber");
		String machName = request.getParameter("machName");
		String machState = request.getParameter("machState");
		String outRoomNumber = request.getParameter("outRoomNumber");
		String customerName = request.getParameter("customerName");
		String customerCompany = request.getParameter("customerCompany");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		MOutroommach t = new MOutroommach();
		t.setBoxNumber(boxNumber);
		t.setSerNumber(serNumber);
		t.setMachName(machName);
		t.setMachState(machState);
		t.setOutRoomNumber(outRoomNumber);
		t.setCustomerName(customerName);
		t.setCustomerCompany(customerCompany);
		
		//System.out.println("datavalue:"+boxNumber+"-"+serNumber+"-"+machName+"-"+machState+"-"+outRoomNumber+"-"+customerName+"-"+customerCompany+"-"+starttime+"-"+endtime);
	
		List<MOutroommach> outlist = outRoomMachServiceImp.SelectByParmTime(t, starttime, endtime);
		
//		System.out.println("outlist大小:"+outlist.size());
//		for(MOutroommach mo : outlist){
//			System.out.println("- - :"+mo.getOutRoomDate()+"-"+mo.getOutRoomUserName());
//		}
		
		String date = DateUtil.NowDate();
		String filename = "出货信息表"+date+"";
		String sheetname = "出货信息表";
		String titlename[] = {"订单编号","条形码","生产日期","终端型号","终端ID","通讯模块","定位模块","收货人","收货人电话","收货地址","发货时间","硬件版本","软件版本"};
		String titlecolumn[] = {"outRoomNumber","serNumber","productDate","machName","terminalId","phModule","psModule","customerName","customerPhone","customerAdress","outRoomDate","hardwareversion","softwareversion"};
		int titlesize[] = {10,8,6,6,6,4,4,4,6,12,6,6,6};
		PoiExcelExport poi = new PoiExcelExport(response, filename, sheetname);
		poi.wirteExcel(titlecolumn, titlename, titlesize, outlist, filename);	
	}
	
	
}
