package com.ym.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ym.entity.ImportInfo;

public class ExcelUtil {
	public static List<ImportInfo> readExcelData(Workbook workbook) {
		List<ImportInfo> list = new ArrayList<>();

		// 获取sheet数
		int numberOfSheets = workbook.getNumberOfSheets();
		// 遍历sheet
		for (int i = 0; i < numberOfSheets; i++) {
		// 获取每一个sheet
		Sheet sheet = workbook.getSheetAt(i);
		// 迭代每一行数据
		int rowNumber = sheet.getPhysicalNumberOfRows();
		for (int r = 1; r < rowNumber; r++) {
			ImportInfo userAdd = new ImportInfo();
			// 行对象
			Row row = sheet.getRow(r);
			// 获取列数
			int colNum = row.getPhysicalNumberOfCells();
			for (int j = 0; j < colNum; j++) {
				// 遍历每一列
				Cell cell = row.getCell(j);
				if (j == 0) {
					userAdd.setTiccid(getCellFormatValue(cell));
				}
				if (j == 1) {
					userAdd.setTmsisdn(getCellFormatValue(cell));
				}
				if (j == 2) {
					userAdd.setTsim(getCellFormatValue(cell));
				}
				if (j == 3) {
					userAdd.setTid(getCellFormatValue(cell));
				}
				if (j == 4) {
					userAdd.setTdate(getCellFormatValue(cell));
				}
			} // 单元格迭代结束
			list.add(userAdd);
		} // 行迭代结束
		} // 表迭代结束

		return list;
	}

	/**
	 * 根据HSSFCell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	@SuppressWarnings({ "deprecation" })
	private static String getCellFormatValue(Cell cell) {
		// BigDecimal bd = new BigDecimal(getCellFormatValue(cell));
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_NUMERIC:{
				BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
				cellvalue = bd.toPlainString();
				break;
			}
//			// 错误
//			case Cell.CELL_TYPE_ERROR:
			// boolean
//			case Cell.CELL_TYPE_BOOLEAN:
//			// 空白
//			case Cell.CELL_TYPE_BLANK:
			// 公式类型
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					cellvalue = new SimpleDateFormat("yyyy-MM-dd").format(date);
				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为STRING
			case Cell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	// 获取单元格内不同类型值
	public String getCellStringValue(Cell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}
}
