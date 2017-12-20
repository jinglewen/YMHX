package com.ym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.MMach;
import com.ym.entity.MProductmach;
import com.ym.serviceImp.MachServiceImp;
import com.ym.util.PrintWriterUtil;

@Controller
public class MachController {

	@Autowired
	public MachServiceImp machServiceImp;
	
	//分页查询
	@RequestMapping("/SelectMachByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = machServiceImp.SelectAll().size();
		List<MMach> listbypage = machServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件分页查询
	@RequestMapping("/SelectMachByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, MMach m){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		//System.out.println("name:"+m.getMachName());
		int total = machServiceImp.SelectByParmTime(m, starttime, endtime).size();
		List<MMach> listbypageparm = machServiceImp.SelectByPageParmTime(pageIndex, pageSize, m, starttime, endtime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
	//查询设备历史记录
	@RequestMapping("/Mach_listall")
	public ModelAndView Mach_listall(HttpServletRequest request){
		String sernum = request.getParameter("sernum");
		//System.out.println("sernum:"+sernum);
		List<MProductmach> listpro = machServiceImp.SelectProBySerNum(sernum);//生产机历史
		ModelAndView mv = new ModelAndView();
		mv.addObject("listpro", listpro);
		mv.setViewName("ym_mach/mach_listall.jsp");
		return mv;
	}
	
}
