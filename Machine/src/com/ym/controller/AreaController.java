package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ym.entity.UArea;
import com.ym.entity.UUserinfo;
import com.ym.serviceImp.AreaServiceImp;
import com.ym.util.DateUtil;
import com.ym.util.PrintWriterUtil;

@Controller
public class AreaController {

	@Autowired
	public AreaServiceImp areaServiceImp;
	
	//添加
	@RequestMapping("/AddArea")
	public void Add(HttpServletRequest request, HttpServletResponse response, UArea uArea){
		UUserinfo u = (UUserinfo) request.getSession().getAttribute("userinfo");
		Map<String, Object> map = new HashMap<String, Object>();
		uArea.setAreaDescription(uArea.getAreaName());
		uArea.setOptionUser(u.getUserName());
		uArea.setOptionTime(DateUtil.NowTime());
		areaServiceImp.Add(uArea);
		map.put("ErrorCode", 0);//添加成功
		PrintWriterUtil.Out(response, map);
	}
	
	//更新
	@RequestMapping("UpdateArea")
	public void Update(HttpServletRequest request, HttpServletResponse response, UArea uArea){
		UUserinfo uu = (UUserinfo) request.getSession().getAttribute("userinfo");
		int id = Integer.valueOf(request.getParameter("id"));
		UArea ua = areaServiceImp.SelectById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(ua != null){
			ua.setAreaName(uArea.getAreaName());
			ua.setAreaDescription(uArea.getAreaName());
			ua.setChargeUserName(uArea.getChargeUserName());
			ua.setOptionUser(uu.getUserName());
			areaServiceImp.Update(ua);
			map.put("ErrorCode", 1);//更新成功
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//删除
	@RequestMapping("/DeleteeArea")
	public void Deletee(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.valueOf(request.getParameter("id"));
		UArea ua = areaServiceImp.SelectById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(ua != null){
			map.put("ErrorCode", 0);//删除成功
			areaServiceImp.Deletee(ua);
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//查询所有
	@RequestMapping("/SelectAreaAll")
	public void SelectAll(HttpServletResponse response){
		Map<String, Object> map = new HashMap<>();
		List<UArea> listall = areaServiceImp.SelectAll();
		map.put("rows", listall);
		PrintWriterUtil.Out(response, map);
	}
	
	//分页查询
	@RequestMapping("/SelectAreaByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = areaServiceImp.SelectAll().size();
		List<UArea> listbypage = areaServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件查询
	@RequestMapping("/SelectAreaByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, UArea t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = areaServiceImp.SelectByParm(t).size();
		List<UArea> listbypageparm = areaServiceImp.SelectByPageParm(pageIndex, pageSize, t);
		//System.out.println("total-pagesize:"+total+"-"+listbypageparm.size());
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
}
