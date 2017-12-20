package com.ym.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.TDetectionItem2017;
import com.ym.entity.TDetectionMain2017;
import com.ym.serviceImp.DetectionMain2017ServiceImp;
import com.ym.util.AssayTypeUtil;
import com.ym.util.DateUtil;
import com.ym.util.PoiExcelExport;
import com.ym.util.PrintWriterUtil;

@Controller
@SessionAttributes("deteitem2017")
public class DetectionMain2017Controller {

	@Autowired
	public DetectionMain2017ServiceImp detectionMain2017ServiceImp;
	
	//分页查询
	@RequestMapping("/SelectDetectionMain2017ByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = detectionMain2017ServiceImp.SelectAll().size();
		List<TDetectionMain2017> listbypage = detectionMain2017ServiceImp.SelectByPage(pageIndex, pageSize);
		
//		System.out.println("total:"+total);
//		for(TDetectionMain2017 td : listbypage){
//			System.out.println("time:"+td.getCreationTime());
//		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
	
	//条件分页查询
	@RequestMapping("/SelectDetectionMain2017ByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, TDetectionMain2017 t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		//System.out.println("page:"+pageIndex+"-"+pageSize+"-"+starttime+"-"+endtime+"-"+t.getBatchNumber()+"-"+t.getDetectionType()+"-"+t.getResult());
		int total = detectionMain2017ServiceImp.SelectByParmTime(t, starttime, endtime).size();
		List<TDetectionMain2017> listbypageparm = detectionMain2017ServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	
	//根据本表的Id查询DetectionItem2017
	@RequestMapping("/TDetectionMain2017_listbyid")
	public ModelAndView SelectItem2017ById(HttpServletRequest request){
		String Id = request.getParameter("tdid");
		List<TDetectionItem2017> listitem = detectionMain2017ServiceImp.SelectItem2017ById(Id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("deteitem2017", listitem);
		mv.setViewName("ym_check/t_detemain_to_deteitem2017.jsp");
		return mv;
	}
	
	//导出数据ByParm
	@RequestMapping("/TDetectionMain2017_exportExcelbyparm")
	public void ExportExcelByParm(HttpServletRequest request, HttpServletResponse response){
		String batchNumber = request.getParameter("batchNumber");
		int detectionType = Integer.valueOf(request.getParameter("detectionType"));
		String result = request.getParameter("result");
		String terminalModel = request.getParameter("terminalModel");
		String createrRealName = request.getParameter("createrRealName");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		TDetectionMain2017 td2017 = new TDetectionMain2017();
		td2017.setBatchNumber(batchNumber);
		td2017.setDetectionType(detectionType);
		td2017.setResult(result);
		td2017.setTerminalModel(terminalModel);
		td2017.setCreaterRealName(createrRealName);
		List<TDetectionMain2017> listtd2017 = detectionMain2017ServiceImp.SelectByParmTime(td2017, starttime, endtime);
		for(TDetectionMain2017 e : listtd2017){
			System.out.println("jing:===="+e);
		}
		String date = DateUtil.NowDate();
		String filename = "检测2017信息表"+date+"";
		String sheetname = "检测信息表";
		String titlename[] = {"终端序列号","终端类型","检测类型","检测结果","检测时间"};
		String titlecolumn[] = {"batchNumber","terminalModel","detectionType","result","creationTime"};
		int titlesize[] = {10,6,6,6,8};
		PoiExcelExport poi = new PoiExcelExport(response, filename, sheetname);
		poi.wirteExcel(titlecolumn, titlename, titlesize, listtd2017, filename);
		
	}
	
	//导出数据Excel(包含附表的Fail)
	@RequestMapping("/TDetectionMain2017_exportExcel")
	public void ExportExcel(HttpServletRequest request, HttpServletResponse response){
		String batchNumber = request.getParameter("batchNumber");
		int detectionType = Integer.valueOf(request.getParameter("detectionType"));
		String result = request.getParameter("result");
		String terminalModel = request.getParameter("terminalModel");
		String createrRealName = request.getParameter("createrRealName");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		TDetectionMain2017 td2017 = new TDetectionMain2017();
		td2017.setBatchNumber(batchNumber);
		td2017.setDetectionType(detectionType);
		td2017.setResult(result);
		td2017.setTerminalModel(terminalModel);
		td2017.setCreaterRealName(createrRealName);
		
		System.out.println("td2017:"+batchNumber+""+detectionType+""+result+""+starttime+""+endtime);
		
		List<TDetectionMain2017> listtd2017 = detectionMain2017ServiceImp.SelectByParmTime(td2017, starttime, endtime);
		System.out.println("listyd2017大小:"+listtd2017.size());
		
//		for(TDetectionMain2017 dt : listtd2017){
//			System.out.println("dt.getId:"+dt.getId());
//			List<TDetectionItem2017> listit2017 = detectionMain2017ServiceImp.SelectItem2017FailById(dt.getId());
//			System.out.println("listit2017大小:"+listit2017.size());
//		}
		
		HSSFWorkbook wb = new HSSFWorkbook(); // 第一步，创建一个webbook，对应一个Excel文件 
		HSSFSheet sheet = wb.createSheet("检测信息表"); // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
	    sheet.setColumnWidth(0, 8000);
	    sheet.setColumnWidth(1, 6000);
	    sheet.setColumnWidth(2, 6000);
	    sheet.setColumnWidth(3, 6000);
	    sheet.setColumnWidth(4, 5000);
	    sheet.setColumnWidth(5, 8000);
	    sheet.setColumnWidth(6, 5000);
	    sheet.setColumnWidth(7, 5000);
	    HSSFRow row = sheet.createRow((int) 0); // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	    HSSFCellStyle style = wb.createCellStyle(); // 第四步，创建单元格，并设置值表头 设置表头居中 
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
	    
	    HSSFCell cell = row.createCell(0);  
	    cell.setCellValue("终端序列号");  
        cell.setCellStyle(style); 
        
        cell = row.createCell(1);
	    cell.setCellValue("终端类型");  
        cell.setCellStyle(style);
        
        cell = row.createCell(2);  
        cell.setCellValue("检测类型");  
        cell.setCellStyle(style); 
        
        cell = row.createCell(3); 
        cell.setCellValue("检测时间");  
        cell.setCellStyle(style);
        
        cell = row.createCell(4); 
        cell.setCellValue("检测结果");  
        cell.setCellStyle(style);
        
        cell = row.createCell(5);  
        cell.setCellValue("检测项目");  
        cell.setCellStyle(style);
        
        cell = row.createCell(6);  
        cell.setCellValue("项目检测结果");  
        cell.setCellStyle(style);
        
        cell = row.createCell(7);  
        cell.setCellValue("检测状态");  
        cell.setCellStyle(style);
        
        int rownum = 1;
        for(int i = 0; i < listtd2017.size(); i++){  
        	TDetectionMain2017 dt2017 = listtd2017.get(i);
        	List<TDetectionItem2017> listit2017 = detectionMain2017ServiceImp.SelectItem2017FailById(dt2017.getId());
        	if(listit2017.size() > 0){
        		for(int j = 0; j < listit2017.size(); j++){
        			
        			row = sheet.createRow(rownum);//创建第几行
        			
            		// 第四步，创建单元格，并设置值  
                    HSSFCell cell1 = row.createCell(0);  
                    cell1.setCellValue(dt2017.getBatchNumber());//终端序列号  // 第五步，写入实体数据 实际应用中这些数据从数据库得到
                    cell1.setCellStyle(style);
                    
                    cell1 = row.createCell(1);  
                    cell1.setCellValue(dt2017.getTerminalModel());//终端类型  
                    cell1.setCellStyle(style);
                    
                    cell1 = row.createCell(2); 
                    if(dt2017.getDetectionType() == 1){
	                	cell1.setCellValue("模块检测");//检测类型 
	                }
	                if(dt2017.getDetectionType() == 2){
	                	cell1.setCellValue("单板检测");//检测类型
	                }
	                if(dt2017.getDetectionType() == 3){
	                	cell1.setCellValue("整机检测");//检测类型
	                }
                    cell1.setCellStyle(style); 
                    
                    cell1 = row.createCell(3);
                    cell1.setCellValue(dt2017.getCreationTime());//检测时间 
                    cell1.setCellStyle(style);
                    
                    cell1 = row.createCell(4);
                    cell1.setCellValue(dt2017.getResult());//检测结果  
                    cell1.setCellStyle(style); 
                    
                    cell1 = row.createCell(5);  
                    cell1.setCellValue(AssayTypeUtil.lookForAssayType(listit2017.get(j).getAssayType()));//检测项目
                    cell1.setCellStyle(style);
                    
                    cell1 = row.createCell(6);  
                    cell1.setCellValue(listit2017.get(j).getResult());//检测项目结果  
                    cell1.setCellStyle(style);
                    
                    cell1 = row.createCell(7);
                    cell1.setCellValue(listit2017.get(j).getState());//检测状态
                    cell1.setCellStyle(style);
                    
                    rownum ++;
            	}
        	}
        }
        String date = DateUtil.NowDate();
        String filename = "检测2017不通过项目"+date+".xls";
        OutputStream out = null;
        try {
			out = response.getOutputStream();
	        response.setContentType("application/x-msdownload");  
	        response.setHeader("Content-Disposition", "attachment; filename="  
	                + URLEncoder.encode(filename, "UTF-8"));
	        wb.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {  
            	out.flush();
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
		} 
        
        
	}
	
}
