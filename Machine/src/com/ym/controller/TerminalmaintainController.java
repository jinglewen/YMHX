package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ym.entity.TTerminalmaintain;
import com.ym.serviceImp.TerminalmaintainServiceImp;
import com.ym.util.PrintWriterUtil;

@Controller
public class TerminalmaintainController {

	@Autowired
	public TerminalmaintainServiceImp terminalmaintainServiceImp;
	
	//分页查询
	@RequestMapping("/SelectTerminalmaintainByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = terminalmaintainServiceImp.SelectAll().size();
		List<TTerminalmaintain> listbypage = terminalmaintainServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		
//		System.out.println("total:"+total);
//		for(TTerminalmaintain t : listbypage){
//			System.out.println("num-ctime-mdate:"+t.getBoxNumber()+"-"+t.getCreationTime()+"-"+t.getModifyTime());
//		}
		
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//分页查询
	@RequestMapping("/SelectTerminalmaintainByPageParm")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response, TTerminalmaintain t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		
		//System.out.println("page:"+pageIndex+"-"+pageSize+"-"+starttime+"-"+endtime+"-"+t.getBoxNumber()+"-"+t.getBoxState()+"-"+t.getWholeMachineId());
		
		int total = terminalmaintainServiceImp.SelectByParmTime(t, starttime, endtime).size();
		List<TTerminalmaintain> listbypageparm = terminalmaintainServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
}
