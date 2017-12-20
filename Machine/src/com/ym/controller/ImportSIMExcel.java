package com.ym.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.ImportInfo;
import com.ym.entity.TTerminalsimmap;
import com.ym.serviceImp.ImportExcelServiceImp;
import com.ym.util.ExcelUtil;
import com.ym.util.PrintWriterUtil;

@Controller
public class ImportSIMExcel {
	
	@Autowired
	public ImportExcelServiceImp importExcelServiceImp;
	
	@RequestMapping(value = "/importExcel", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView importExcel(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		if(ServletFileUpload.isMultipartContent(request)){
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(10*1024*1024);
            //临时 
            factory.setRepository(new File("\\tempload"));
            ServletFileUpload fileUpload=new ServletFileUpload(factory);
            fileUpload.setFileSizeMax(10*1024*1024);//设置最大文件大小
            try {
                @SuppressWarnings("unchecked")
                List<FileItem> items=fileUpload.parseRequest(request);//获取所有表单
                for(FileItem item:items){
                    //判断当前的表单控件是否是一个普通控件
                    if(!item.isFormField()){
                        //是一个文件控件时
                        String excelFileName = new String(item.getName().getBytes(), "utf-8"); //获取上传文件的名称
                        //上传文件必须为excel类型,根据后缀判断(xls)
                        String excelContentType = excelFileName.substring(excelFileName.lastIndexOf(".")); //获取上传文件的类型
                        //System.out.println("上传文件名:"+excelFileName);
                       // System.out.println("文件大小:"+item.getSize());
                       // System.out.println("\n---------------------------------------");
                        //版本问题
                        if(".xls".equals(excelContentType)){
                            HSSFWorkbook workbook = new HSSFWorkbook(item.getInputStream());
                            List<ImportInfo> list=ExcelUtil.readExcelData(workbook);
                            /*for(ImportInfo i:list){
                        		//System.out.println(i.getTdate()+"||"+i.getTiccid()+"||"+i.getTid()+"||"+i.getTmsisdn()+"||"+i.getTsim());
                        	}*/
                            modelAndView.addObject("UserList", list);
                        }else if(".xlsx".equals(excelContentType)){
                        	XSSFWorkbook workbook = new XSSFWorkbook(item.getInputStream());
                        	List<ImportInfo> list=ExcelUtil.readExcelData(workbook);
                			importExcelServiceImp.saveOrUpdate(list);
                        		//System.out.println(i.getTdate()+"||"+i.getTiccid()+"||"+i.getTid()+"||"+i.getTmsisdn()+"||"+i.getTsim());
                        	//modelAndView.addObject("UserList", list);
                        }else{
                        	//System.out.println("必须为excel类型");
                        }
                        //顺便把文件保存到硬盘,防止重名
//                        String newName=new SimpleDateFormat("yyyyMMDDHHmmssms").format(new Date());
//                        File file = new File("d:/upload");
//                        if(!file.exists()){
//                            file.mkdir();
//                        }
//                        item.write(new File("d:/upload/"+newName+excelContentType));
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
		modelAndView.setViewName("ym_check/t_simexcelimport.jsp");
		return modelAndView;	
	}
	
	//条件分页查询
	@RequestMapping("/SelectSIMImportByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, ImportInfo t){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = importExcelServiceImp.SelectByParm(t).size();
		List<ImportInfo> listbypageparm = importExcelServiceImp.SelectByPageParm(pageIndex, pageSize, t);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
	//预加载
	@RequestMapping("/SelectSIMImportByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //page
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = importExcelServiceImp.SelectAll().size();
		List<ImportInfo> listbypage = importExcelServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
}
