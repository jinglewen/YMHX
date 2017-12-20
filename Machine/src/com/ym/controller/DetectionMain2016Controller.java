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
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.TDetectionItem2016;
import com.ym.entity.TDetectionMain2016;
import com.ym.serviceImp.DetectionMain2016ServiceImp;
import com.ym.util.AssayTypeUtil;
import com.ym.util.DateUtil;
import com.ym.util.PoiExcelExport;
import com.ym.util.PrintWriterUtil;

@Controller
public class DetectionMain2016Controller {

	@Autowired
	public DetectionMain2016ServiceImp detectionMain2016ServiceImp;
	
	//分页查询
		@RequestMapping("/SelectDetectionMain2016ByPage")
		public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
			int pageIndex = Integer.valueOf(request.getParameter("page")); //page
			int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
			int total = detectionMain2016ServiceImp.SelectAll().size();
			List<TDetectionMain2016> listbypage = detectionMain2016ServiceImp.SelectByPage(pageIndex, pageSize);
			
//			System.out.println("total:"+total);
//			for(TDetectionMain2016 td : listbypage){
//				System.out.println("time:"+td.getCreationTime());
//			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", total);
			map.put("rows", listbypage);
			PrintWriterUtil.Out(response, map);
		}
		
		//条件分页查询
		@RequestMapping("/SelectDetectionMain2016ByPageParm")
		public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, TDetectionMain2016 t){
			int pageIndex = Integer.valueOf(request.getParameter("page")); //page
			int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			//System.out.println("page:"+pageIndex+"-"+pageSize+"-"+starttime+"-"+endtime+"-"+t.getBatchNumber()+"-"+t.getDetectionType()+"-"+t.getResult());
			int total = detectionMain2016ServiceImp.SelectByParmTime(t, starttime, endtime).size();
			List<TDetectionMain2016> listbypageparm = detectionMain2016ServiceImp.SelectByPageParmTime(pageIndex, pageSize, t, starttime, endtime);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", total);
			map.put("rows", listbypageparm);
			PrintWriterUtil.Out(response, map);
		}
		
		//根据本表的Id查询DetectionItem2016
		@RequestMapping("/TDetectionMain2016_listbyid")
		public ModelAndView SelectItem2016ById(HttpServletRequest request){
			String Id = request.getParameter("tdid");
			List<TDetectionItem2016> listitem = detectionMain2016ServiceImp.SelectItem2016ById(Id);
			ModelAndView mv = new ModelAndView();
			mv.addObject("deteitem2016", listitem);
			mv.setViewName("ym_check/t_detemain_to_deteitem2016.jsp");
			return mv;
		}
	
		//导出数据ByParm
		@RequestMapping("/TDetectionMain2016_exportExcelbyparm")
		public void ExportExcelByParm(HttpServletRequest request, HttpServletResponse response){
			String batchNumber = request.getParameter("batchNumber");
			int detectionType = Integer.valueOf(request.getParameter("detectionType"));
			String result = request.getParameter("result");
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			TDetectionMain2016 td2016 = new TDetectionMain2016();
			td2016.setBatchNumber(batchNumber);
			td2016.setDetectionType(detectionType);
			td2016.setResult(result);
			List<TDetectionMain2016> listtd2016 = detectionMain2016ServiceImp.SelectByParmTime(td2016, starttime, endtime);
			
			String date = DateUtil.NowDate();
			String filename = "检测2016信息表"+date+"";
			String sheetname = "检测信息表";
			String titlename[] = {"终端序列号","终端类型","检测类型","检测结果","检测时间"};
			String titlecolumn[] = {"batchNumber","terminalModel","detectionType","result","creationTime"};
			int titlesize[] = {10,6,6,6,8};
			PoiExcelExport poi = new PoiExcelExport(response, filename, sheetname);
			poi.wirteExcel(titlecolumn, titlename, titlesize, listtd2016, filename);
			
		}
		
		//导出数据Excel(包含附表的Fail)
		@RequestMapping("/TDetectionMain2016_exportExcel")
		public void ExportExcel(HttpServletRequest request, HttpServletResponse response){
			String batchNumber = request.getParameter("batchNumber");
			int detectionType = Integer.valueOf(request.getParameter("detectionType"));
			String result = request.getParameter("result");
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			TDetectionMain2016 td2016 = new TDetectionMain2016();
			td2016.setBatchNumber(batchNumber);
			td2016.setDetectionType(detectionType);
			td2016.setResult(result);
			
//			System.out.println("td2016:"+batchNumber+""+detectionType+""+result+""+starttime+""+endtime);
			
			List<TDetectionMain2016> listtd2016 = detectionMain2016ServiceImp.SelectByParmTime(td2016, starttime, endtime);
			System.out.println("listyd2016大小:"+listtd2016.size());
			
//			for(TDetectionMain2016 dt : listtd2016){
//				System.out.println("dt.getId:"+dt.getId());
//				List<TDetectionItem2016> listit2016 = detectionMain2016ServiceImp.SelectItem2016FailById(dt.getId());
//				System.out.println("listit2016大小:"+listit2016.size());
//			}
			
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
	        for(int i = 0; i < listtd2016.size(); i++){ 
	        	TDetectionMain2016 dt2016 = listtd2016.get(i);
	        	List<TDetectionItem2016> listit2016 = detectionMain2016ServiceImp.SelectItem2016FailById(dt2016.getId());
	        	if(listit2016.size() > 0){
	        		for(int j = 0; j < listit2016.size(); j++){
	        			
	        			row = sheet.createRow(rownum);//创建第几行
	        			
		        		// 第四步，创建单元格，并设置值  
		                HSSFCell cell1 = row.createCell(0);  
		                cell1.setCellValue(dt2016.getBatchNumber());//终端序列号  // 第五步，写入实体数据 实际应用中这些数据从数据库得到
		                cell1.setCellStyle(style);
		                
		                cell1 = row.createCell(1);  
		                cell1.setCellValue(dt2016.getTerminalModel());//终端类型  
		                cell1.setCellStyle(style);
		                
		                cell1 = row.createCell(2);
		                if(dt2016.getDetectionType() == 1){
		                	cell1.setCellValue("模块检测");//检测类型 
		                }
		                if(dt2016.getDetectionType() == 2){
		                	cell1.setCellValue("单板检测");//检测类型
		                }
		                if(dt2016.getDetectionType() == 3){
		                	cell1.setCellValue("整机检测");//检测类型
		                }
		                cell1.setCellStyle(style); 
		                
		                cell1 = row.createCell(3);
		                cell1.setCellValue(dt2016.getCreationTime());//检测时间  
		                cell1.setCellStyle(style);
		                
		                cell1 = row.createCell(4);
		                cell1.setCellValue(dt2016.getResult());//检测结果  
		                cell1.setCellStyle(style); 
		                
		                cell1 = row.createCell(5);
		                cell1.setCellValue(AssayTypeUtil.lookForAssayType(listit2016.get(j).getAssayType()));//检测项目
		                cell1.setCellStyle(style);
		                
		                cell1 = row.createCell(6);  
		                cell1.setCellValue(listit2016.get(j).getResult());//检测项目结果  
		                cell1.setCellStyle(style);
		                
		                cell1 = row.createCell(7);
		                cell1.setCellValue(listit2016.get(j).getState());//检测状态
		                cell1.setCellStyle(style);
		                
		                rownum ++;
		        	}
	        	}
	        }
	        
	        String date = DateUtil.NowDate();
	        String filename = "检测2016不通过项目"+date+".xls";
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
