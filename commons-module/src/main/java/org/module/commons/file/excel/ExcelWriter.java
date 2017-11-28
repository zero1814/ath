package org.module.commons.file.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * 类: ExcelWriter <br>
 * 描述: 编写excel <br>
 * 作者: zhy<br>
 * 时间: 2017年11月23日 下午1:29:04
 */
public class ExcelWriter {

	private static final String XLSX = "xlsx";
	private static final String XLS = "xls";

	public static void createExcel(String path, List<?> data, String writePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		Workbook work = null;
		try {
			String type = path.substring(path.lastIndexOf("."), path.length());
			File file = new File(path);
			if (file.exists()) {
				fis = new FileInputStream(file);
				if (StringUtils.equals(type, XLSX)) {
					work = new XSSFWorkbook(fis);
				} else {
					work = new HSSFWorkbook(fis);
				}
				for (Object obj : data) {
					obj.getClass().getFields();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String path = "D:\\test.xlsx";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file = new File(path);
			fis = new FileInputStream(file);
			Workbook work = new XSSFWorkbook(fis);
			// 得到excel的第0张表
			Sheet sheet = work.getSheetAt(0);
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("test");
			fos = new FileOutputStream(new File("d:\\test1.xlsx"));
			work.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
