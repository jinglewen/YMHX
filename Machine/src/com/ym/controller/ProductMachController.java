package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ym.entity.MProductmach;
import com.ym.serviceImp.ProductMachServiceImp;
import com.ym.util.PrintWriterUtil;

@Controller
public class ProductMachController {

	@Autowired
	public ProductMachServiceImp productMachServiceImp;
	
	//分页查询
	@RequestMapping("/SelectProductMachByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = productMachServiceImp.SelectAll().size();
		List<MProductmach> listbypage = productMachServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件查询
	@RequestMapping("/SelectProductMachByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, MProductmach t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		int total = productMachServiceImp.SelectByParmTime(t, starttime, endtime).size();
		List<MProductmach> listbypageparm = productMachServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
}
