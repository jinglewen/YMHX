package com.ym.util;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.lang.reflect.Method;  
import java.net.URLEncoder;  
import java.text.DecimalFormat;  
import java.util.List;  
  

import javax.servlet.http.HttpServletResponse;  
  

import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFFont;  
import org.apache.poi.hssf.usermodel.HSSFPalette;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellStyle;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.util.CellRangeAddress;



public class PoiExcelExport {

	HttpServletResponse response;  

    private String fileName;  

    private String fileDir;  
 
    private String sheetName;  

    private String titleFontType = "Arial Unicode MS";  

    private String titleBackColor = "C1FBEE";  

    private short titleFontSize = 12;  

    private String address = "";  

    private String contentFontType = "Arial Unicode MS";  

    private short contentFontSize = 12;  

    private String floatDecimal = ".00";  
  
    private String doubleDecimal = ".00";  

    private String colFormula[] = null;  
      
    DecimalFormat floatDecimalFormat=new DecimalFormat(floatDecimal);  
    DecimalFormat doubleDecimalFormat=new DecimalFormat(doubleDecimal);  
      
    private HSSFWorkbook workbook = null;  
      
    public PoiExcelExport(String fileDir,String sheetName){  
         this.fileDir = fileDir;  
         this.sheetName = sheetName;  
         workbook = new HSSFWorkbook();  
    }  
      
    public PoiExcelExport(HttpServletResponse response,String fileName,String sheetName){  
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
 
    public void setContentFontType(String contentFontType) {  
        this.contentFontType = contentFontType;  
    }  
 
    public void setContentFontSize(short contentFontSize) {  
        this.contentFontSize = contentFontSize;  
    }  
 
    public void setDoubleDecimal(String doubleDecimal) {  
        this.doubleDecimal = doubleDecimal;  
    }  
   
    public void setFloatDecimalFormat(DecimalFormat floatDecimalFormat) {  
        this.floatDecimalFormat = floatDecimalFormat;  
    }  
  
    public void setColFormula(String[] colFormula) {  
        this.colFormula = colFormula;  
    }  
    
    //导出
    public void wirteExcel(String titleColumn[],String titleName[],int titleSize[],List<?> dataList,String filename){  
         
        Sheet sheet = workbook.createSheet(this.sheetName);    
        
        OutputStream out = null;  
        try {      
            if(fileDir!=null){
                out = new FileOutputStream(fileDir);                  
            }else{  
                out = response.getOutputStream();  
                filename = filename+".xls";  
                response.setContentType("application/x-msdownload");  
                response.setHeader("Content-Disposition", "attachment; filename="  
                        + URLEncoder.encode(filename, "UTF-8"));  
            }        
 
            
            Row titleNameRow = workbook.getSheet(sheetName).createRow(0);   
             
            HSSFCellStyle titleStyle = workbook.createCellStyle();    
            titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, titleFontType, (short) titleFontSize);  
            titleStyle = (HSSFCellStyle) setColor(titleStyle, titleBackColor, (short)10);  
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ
            
            for(int i = 0;i < titleName.length;i++){  
                sheet.setColumnWidth(i, titleSize[i]*1000);    //���ÿ��          
                Cell cell = titleNameRow.createCell(i);  
                cell.setCellStyle(titleStyle);  
                cell.setCellValue(titleName[i].toString());  
            }  
              
            
            if(!"".equals(address)){  
                CellRangeAddress c = (CellRangeAddress) CellRangeAddress.valueOf(address);  
                sheet.setAutoFilter(c);  
            }  
              
         
            if(dataList!=null&&dataList.size()>0){  
               
                HSSFCellStyle dataStyle = workbook.createCellStyle();
                dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, contentFontType, (short) contentFontSize);  
                  
                if(titleColumn.length>0){  
                    for(int rowIndex = 1;rowIndex<=dataList.size();rowIndex++){  
                        Object obj = dataList.get(rowIndex-1);     
                        Class clsss = obj.getClass();     
                        Row dataRow = workbook.getSheet(sheetName).createRow(rowIndex);      
                        for(int columnIndex = 0;columnIndex<titleColumn.length;columnIndex++){  
                            String title = titleColumn[columnIndex].toString().trim();  
                            if(!"".equals(title)){    
                                 
                                String UTitle = Character.toUpperCase(title.charAt(0))+ title.substring(1, title.length()); // ʹ������ĸ��д;  
                                String methodName  = "get"+UTitle;  
                                  
                                
                                Method method = clsss.getDeclaredMethod(methodName);   
                                  
                               
                                String returnType = method.getReturnType().getName();   
                                  
                                String data = method.invoke(obj)==null?"":method.invoke(obj).toString();  
                                Cell cell = dataRow.createCell(columnIndex);
                                cell.setCellStyle(dataStyle);
                                if(data!=null&&!"".equals(data)){  
                                    if("int".equals(returnType)){  
                                        cell.setCellValue(Integer.parseInt(data));  
                                    }else if("long".equals(returnType)){  
                                        cell.setCellValue(Long.parseLong(data));  
                                    }else if("float".equals(returnType)){  
                                        cell.setCellValue(floatDecimalFormat.format(Float.parseFloat(data)));  
                                    }else if("double".equals(returnType)){  
                                        cell.setCellValue(doubleDecimalFormat.format(Double.parseDouble(data)));  
                                    }else{  
                                        cell.setCellValue(data);  
                                    }  
                                }  
                            }else{   
                                if(colFormula!=null){  
                                    String sixBuf = colFormula[columnIndex].replace("@", (rowIndex+1)+"");  
                                    Cell cell = dataRow.createCell(columnIndex);  
                                    cell.setCellFormula(sixBuf.toString());  
                                }  
                            }  
                        }  
                    }  
                      
                }  
            }  
              
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
     
  
    public CellStyle setFontAndBorder(CellStyle style,String fontName,short size){  
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
