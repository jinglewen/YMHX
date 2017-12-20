package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ym.entity.TTerminalsimmap;
import com.ym.serviceImp.TerminalsimmapServiceImp;
import com.ym.util.PrintWriterUtil;

@Controller
public class TerminalsimmapController {

	@Autowired
	public TerminalsimmapServiceImp terminalsimmapServiceImp;
	
	//分页查询
	@RequestMapping("/SelectTerminalsimmapByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = terminalsimmapServiceImp.SelectAll().size();
		List<TTerminalsimmap> listbypage = terminalsimmapServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//分页查询
	@RequestMapping("/SelectTerminalsimmapByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, TTerminalsimmap t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = terminalsimmapServiceImp.SelectByParm(t).size();
		List<TTerminalsimmap> listbypageparm = terminalsimmapServiceImp.SelectByPageParm(pageIndex, pageSize, t);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
}
