package com.ym.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.TDetectionItem2018;
import com.ym.entity.TDetectionMain2018;
import com.ym.serviceImp.DetectionMain2018ServiceImp;
import com.ym.util.PoiExcelExports;
import com.ym.util.PrintWriterUtil;

import net.sf.json.JSONArray;

@Controller
@SessionAttributes("deteitem2018")
public class DetectionMain2018Controller {

	@Autowired
	public DetectionMain2018ServiceImp detectionMain2018ServiceImp;
	
	//分页查询
	@RequestMapping("/SelectDetectionMain2018ByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = detectionMain2018ServiceImp.SelectAll().size();
		List<TDetectionMain2018> listbypage = detectionMain2018ServiceImp.SelectByPage(pageIndex, pageSize);
		
//		System.out.println("total:"+total);
//		for(TDetectionMain2018 td : listbypage){
//			System.out.println("time:"+td.getCreationTime());
//		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件分页查询
	@RequestMapping("/SelectDetectionMain2018ByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, TDetectionMain2018 t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		//System.out.println("page:"+pageIndex+"-"+pageSize+"-"+starttime+"-"+endtime+"-"+t.getBatchNumber()+"-"+t.getDetectionType()+"-"+t.getResult());
		int total = detectionMain2018ServiceImp.SelectByParmTime(t, starttime, endtime).size();
		List<TDetectionMain2018> listbypageparm = detectionMain2018ServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
	//根据本表的Id查询DetectionItem2018
	@RequestMapping("/TDetectionMain2018_listbyid")
	public ModelAndView SelectItem2018ById(HttpServletRequest request){
		String Id = request.getParameter("tdid");
		List<TDetectionItem2018> listitem = detectionMain2018ServiceImp.SelectItem2018ById(Id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("deteitem2018", listitem);
		mv.setViewName("ym_check/t_detemain_to_deteitem2018.jsp");
		return mv;
	}
	
	//导出Excel
	@RequestMapping("/ExportExcel")
	public void ExportExcel(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException{
		
		//表格的数据
		String param = request.getParameter("param");
		//表格的名字
		String cols = request.getParameter("cols");
		//文件名
		String fileName = request.getParameter("fileName");
		//时间段
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		//标题
		String titleName = request.getParameter("titleName");
		JSONArray titleJsonObject = JSONArray.fromObject(cols);
		JSONArray jsonObject = new JSONArray();
		if (param == null) {
			int i = 0;
			while(true) {
				param = request.getParameter("param" + i);
				if (param == null)
					break;

				JSONArray jsonArray = JSONArray.fromObject(param);
				jsonObject.addAll(jsonArray);
				i++;
			}
		} else {
			jsonObject = JSONArray.fromObject(param);
		}
		
		String filename = fileName;
		PoiExcelExports poi = new PoiExcelExports(response, filename, titleName);
		poi.wirteExcel(titleJsonObject, jsonObject, filename, titleName, beginTime, endTime);	
	}
}
