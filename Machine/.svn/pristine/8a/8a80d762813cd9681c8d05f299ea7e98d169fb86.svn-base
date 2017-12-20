package com.ym.util;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.text.DecimalFormat;  
  
import javax.servlet.http.HttpServletResponse;  
  
import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFFont;  
import org.apache.poi.hssf.usermodel.HSSFPalette;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellStyle;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.util.CellRangeAddress;

public class PoiExcelExports {

	HttpServletResponse response;  

    private String fileDir;  
 
    private String sheetName;  

    private String titleFontType = "Arial Unicode MS";  

    private String titleBackColor = "FFFFFF";  

    private short titleFontSize = 12;  

    private String address = "";  

    private String floatDecimal = ".00";  
  
    private String doubleDecimal = ".00";  

    DecimalFormat floatDecimalFormat=new DecimalFormat(floatDecimal);  
    DecimalFormat doubleDecimalFormat=new DecimalFormat(doubleDecimal);  
      
    private HSSFWorkbook workbook = null;  
      
    public PoiExcelExports(String fileDir,String sheetName){  
         this.fileDir = fileDir;  
         this.sheetName = sheetName;  
         workbook = new HSSFWorkbook();  
    }  
      
    public PoiExcelExports(HttpServletResponse response,String fileName,String sheetName){  
         this.response = response;  
         this.sheetName = sheetName;  
         workbook = new HSSFWorkbook();  
    }    
    

    public void setTitleFontType(String titleFontType) {  
        this.titleFontType = titleFontType;  
    }  
 
    public void setTitleBackColor(String titleBackColor) {  
        this.titleBackColor = titleBackColor;  
    }  
 
    public void setTitleFontSize(short titleFontSize) {  
        this.titleFontSize = titleFontSize;  
    }  
 
    public void setAddress(String address) {  
        this.address = address;  
    }  
 
    public void setDoubleDecimal(String doubleDecimal) {  
        this.doubleDecimal = doubleDecimal;  
    }  
   
    public void setFloatDecimalFormat(DecimalFormat floatDecimalFormat) {  
        this.floatDecimalFormat = floatDecimalFormat;  
    }  
  
    //公共导出excel
    public void wirteExcel(JSONArray titleColumn, JSONArray dataList, String filename, String titleName, String beginTime, String endTime){  
    	Sheet sheet = workbook.createSheet(this.sheetName);    
    	OutputStream out = null;  
    	try {      
    		if(fileDir!=null){
    			out = new FileOutputStream(fileDir);                  
    		}else{  
    			out = response.getOutputStream();  
    			response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题  
    			response.setCharacterEncoding("utf-8");  
    			response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gbk"), "iso8859-1")+".xls");   
    		}        
    		int startRowIndex = 0;
    		//标题设置
    		if(!titleName.equals("")) {
        		HSSFCellStyle titleNameStyle = workbook.createCellStyle();
        		//设置颜色和边框
        		titleNameStyle = (HSSFCellStyle) setTitleFontAndBorder(titleNameStyle, titleFontType, (short) 18);
        		//titleNameStyle = (HSSFCellStyle) setColor(titleNameStyle, titleBackColor, (short) 20);
        		//设置水平居中
        		titleNameStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        		//合并单元格
    	        sheet.addMergedRegion(new CellRangeAddress(startRowIndex, startRowIndex, 0, titleColumn.size() - 1));
        		Row titleRow = workbook.getSheet(sheetName).createRow(startRowIndex++);
        		Cell titleCell = titleRow.createCell(0);
        		titleCell.setCellStyle(titleNameStyle);
        		titleCell.setCellValue(titleName);
    		}
    		//时间段
    		if(!beginTime.equals("") && !endTime.equals("")) {
    	        sheet.addMergedRegion(new CellRangeAddress(startRowIndex, startRowIndex, 0, titleColumn.size() - 1));
        		String titletime = "时间范围: " + beginTime + " 至 " + endTime;
        		Row timeRow = workbook.getSheet(sheetName).createRow(startRowIndex++);
        		Cell timeCell = timeRow.createCell(0);
        		timeCell.setCellValue(titletime);
    		}
    		//年月
    		if(!beginTime.equals("") && endTime.equals("")) {
    			sheet.addMergedRegion(new CellRangeAddress(startRowIndex, startRowIndex, 0, titleColumn.size() - 1));
    			String titletime = "时间: " + beginTime;
    			Row timeRow = workbook.getSheet(sheetName).createRow(startRowIndex++);
    			Cell timeCell = timeRow.createCell(0);
    			timeCell.setCellValue(titletime);
    		}
    		Row titleNameRow = workbook.getSheet(sheetName).createRow(startRowIndex);   
    		//列名
    		for(int i = 0; i < titleColumn.size(); i++) {
    			HSSFCellStyle titleStyle = workbook.createCellStyle();
        		titleStyle = (HSSFCellStyle) setCellFontAndBorder(titleStyle, titleFontType, (short) titleFontSize);
        		titleStyle = (HSSFCellStyle) setColor(titleStyle, titleBackColor, (short)10);
        		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    			Cell cell = titleNameRow.createCell(i);
    			cell.setCellStyle(titleStyle);
    			cell.setCellValue(titleColumn.get(i).toString());
    		}
    		
    		if(!"".equals(address)){  
    			CellRangeAddress c = (CellRangeAddress) CellRangeAddress.valueOf(address);  
    			sheet.setAutoFilter(c);  
    		}
    		//数据
    		if(dataList != null && dataList.size() > 0) {  
    			HSSFCellStyle dataStyle = workbook.createCellStyle();
    			dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    			dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
    			dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
    			dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
    			dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框 
    			dataStyle = (HSSFCellStyle) setColor(dataStyle, titleBackColor, (short) 10);
    			
    			if(titleColumn.size() > 0){  
    				for(int rowIndex = 0; rowIndex<dataList.size(); rowIndex++) {   
    					Row dataRow = workbook.getSheet(sheetName).createRow(rowIndex + startRowIndex + 1); 
    					JSONArray dataArray = (JSONArray) dataList.get(rowIndex);
    					for(int columnIndex = 0; columnIndex < titleColumn.size(); columnIndex++){
							Cell cell = dataRow.createCell(columnIndex);
							cell.setCellStyle(dataStyle);
							cell.setCellValue(dataArray.get(columnIndex).toString());  
    					}  
    				}
    			}  
    		}
    		//设置列宽度
    		sheet.setColumnWidth(0, (int)((25 + 0.72) * 256));
    		sheet.setColumnWidth(1, (int)((25 + 0.72) * 256));
    		sheet.setColumnWidth(2, (int)((25 + 0.72) * 256));
    		sheet.setColumnWidth(3, (int)((25 + 0.72) * 256));
    		sheet.setColumnWidth(4, (int)((25 + 0.72) * 256));
    		sheet.setColumnWidth(5, (int)((25 + 0.72) * 256));
    		
    		workbook.write(out);  
    	} catch (Exception e) {  
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
    public CellStyle setColor(CellStyle style,String color,short index){  
        if(color!=""&&color!=null){  
            int r = Integer.parseInt((color.substring(0,2)),16);
            int g = Integer.parseInt((color.substring(2,4)),16);  
            int b = Integer.parseInt((color.substring(4,6)),16);  
            HSSFPalette palette = workbook.getCustomPalette();   
            palette.setColorAtIndex((short)index, (byte) r, (byte) g, (byte) b);  
          
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);   
            style.setFillForegroundColor(index);  
        }  
        return style;     
    }  
     
  
    public CellStyle setCellFontAndBorder(CellStyle style,String fontName,short size){  
        HSSFFont font = workbook.createFont();    
        font.setFontHeightInPoints(size);      
        font.setFontName(fontName);   
        font.setBold(true);  
        style.setFont(font);  
        style.setBorderBottom(CellStyle.BORDER_THIN);    
        style.setBorderLeft(CellStyle.BORDER_THIN);     
        style.setBorderTop(CellStyle.BORDER_THIN);    
        style.setBorderRight(CellStyle.BORDER_THIN);   
        return style;  
    }  
    
    public CellStyle setTitleFontAndBorder(CellStyle style,String fontName,short size){  
        HSSFFont font = workbook.createFont();    
        font.setFontHeightInPoints(size);      
        font.setFontName(fontName);   
        font.setBold(true);  
        style.setFont(font);  
        return style;  
    } 

    public boolean deleteExcel(){  
        boolean flag = false;  
        File file = new File(this.fileDir);    
        if (!file.exists()) {   
            return flag;    
        } else {      
            if (file.isFile()) {  
                file.delete();  
                flag = true;  
            }   
        }  
        return flag;  
    }  
      
    public boolean deleteExcel(String path){  
        boolean flag = false;  
        File file = new File(path);  
        if (!file.exists()) {   
            return flag;    
        } else {       
            if (file.isFile()) {   
                file.delete();  
                flag = true;  
            }   
        }  
        return flag;  
    }  
	
}
