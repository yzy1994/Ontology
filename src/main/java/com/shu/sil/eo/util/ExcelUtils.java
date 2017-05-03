package com.shu.sil.eo.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.commons.lang3.StringUtils;

public class ExcelUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// boolean ddd = ExcelUtils.createExcelByObjectList("D:/testJXL.xls",
		// "中国", null,null);

	}

	public static boolean createExcelByObjectList(String filePath,
			String fileName, List list, Map<String, String> lableAndFieldMap) {
		if (!StringUtils.isEmpty(filePath) && !StringUtils.isEmpty(fileName)
				&& list.size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个Excel文件
			HSSFSheet sheet = workbook.createSheet(fileName);// 创建一个Excel的Sheet
			Object obj = list.get(0);
			Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(obj
					.getClass());
			HSSFRow row0 = sheet.createRow(0);
			for (int i = 0; i < fieldAllArray.length; i++) {
				Field temp = fieldAllArray[i];
				HSSFCell cell = row0.createCell(i);
				cell.setCellValue(lableAndFieldMap.get(temp.getName()));
			}
			try {
				for (int i = 0; i < list.size(); i++) {
					Object objTemp = list.get(i);
					HSSFRow tempRow = sheet.createRow(i + 1);
					for (int j = 0; j < fieldAllArray.length; j++) {
						Field tempField = fieldAllArray[j];
						// System.out.println(tempField.getName() + "\t" + "\t"
						// + tempField.getType());
						Object value = BaseReflectUtils.invokeGetMethod(
								objTemp, tempField, null);

						// System.out.println(tempField.getName() + "\t" + value
						// + "\t" + tempField.getType());

						if (value != null && !value.toString().equals("")) {
							String valueStr = "";
							if (tempField.getType().getName()
									.equals("java.util.Date")) {

								valueStr = DateUtil.dateToStrLong((Date) value);

							} else {
								valueStr = value.toString();
							}
							HSSFCell cell = tempRow.createCell(j);
							cell.setCellValue(valueStr);
						} else {
							HSSFCell cell = tempRow.createCell(j);
							cell.setCellValue("");

						}

					}
				}
				FileOutputStream fos = new FileOutputStream(filePath);
				workbook.write(fos);
				fos.flush();
				fos.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		} else {
			return false;
		}

	}
	
	public static HSSFWorkbook createExcelByObjectListReturn(String filePath,
			String fileName, List list, Map<String, String> lableAndFieldMap) {
		if (!StringUtils.isEmpty(filePath) && !StringUtils.isEmpty(fileName)
				&& list.size() > 0) {
			HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个Excel文件
			HSSFSheet sheet = workbook.createSheet(fileName);// 创建一个Excel的Sheet
			Object obj = list.get(0);
			Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(obj
					.getClass());
			HSSFRow row0 = sheet.createRow(0);
			for (int i = 0; i < fieldAllArray.length; i++) {
				Field temp = fieldAllArray[i];
				HSSFCell cell = row0.createCell(i);
				cell.setCellValue(lableAndFieldMap.get(temp.getName()));
			}
			try {
				for (int i = 0; i < list.size(); i++) {
					Object objTemp = list.get(i);
					HSSFRow tempRow = sheet.createRow(i + 1);
					for (int j = 0; j < fieldAllArray.length; j++) {
						Field tempField = fieldAllArray[j];
						// System.out.println(tempField.getName() + "\t" + "\t"
						// + tempField.getType());
						Object value = BaseReflectUtils.invokeGetMethod(
								objTemp, tempField, null);

						// System.out.println(tempField.getName() + "\t" + value
						// + "\t" + tempField.getType());

						if (value != null && !value.toString().equals("")) {
							String valueStr = "";
							if (tempField.getType().getName()
									.equals("java.util.Date")) {

								valueStr = DateUtil.dateToStrLong((Date) value);

							} else {
								valueStr = value.toString();
							}
							HSSFCell cell = tempRow.createCell(j);
							cell.setCellValue(valueStr);
						} else {
							HSSFCell cell = tempRow.createCell(j);
							cell.setCellValue("");

						}

					}
				}
//				FileOutputStream fos = new FileOutputStream(filePath);
//				workbook.write(fos);
//				fos.flush();
//				fos.close();
				return workbook;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}

	}

	// public ActionResult excelPrint() {
	// HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个Excel文件
	// HSSFSheet sheet = workbook.createSheet();// 创建一个Excel的Sheet
	// sheet.createFreezePane(1, 3);// 冻结
	// // 设置列宽
	// sheet.setColumnWidth(0, 1000);
	// sheet.setColumnWidth(1, 3500);
	// sheet.setColumnWidth(2, 3500);
	// sheet.setColumnWidth(3, 6500);
	// sheet.setColumnWidth(4, 6500);
	// sheet.setColumnWidth(5, 6500);
	// sheet.setColumnWidth(6, 6500);
	// sheet.setColumnWidth(7, 2500);
	// // Sheet样式
	// HSSFCellStyle sheetStyle = workbook.createCellStyle();
	// // 背景色的设定
	// sheetStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
	// // 前景色的设定
	// sheetStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
	// // 填充模式
	// sheetStyle.setFillPattern(HSSFCellStyle.FINE_DOTS);
	// // 设置列的样式
	// for (int i = 0; i <= 14; i++) {
	// sheet.setDefaultColumnStyle((short) i, sheetStyle);
	// }
	// // 设置字体
	// HSSFFont headfont = workbook.createFont();
	// headfont.setFontName("黑体");
	// headfont.setFontHeightInPoints((short) 22);// 字体大小
	// headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
	// // 另一个样式
	// HSSFCellStyle headstyle = workbook.createCellStyle();
	// headstyle.setFont(headfont);
	// headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	// headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	// headstyle.setLocked(true);
	// headstyle.setWrapText(true);// 自动换行
	// // 另一个字体样式
	// HSSFFont columnHeadFont = workbook.createFont();
	// columnHeadFont.setFontName("宋体");
	// columnHeadFont.setFontHeightInPoints((short) 10);
	// columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	// // 列头的样式
	// HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
	// columnHeadStyle.setFont(columnHeadFont);
	// columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	// columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//
	// 上下居中
	// columnHeadStyle.setLocked(true);
	// columnHeadStyle.setWrapText(true);
	// columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
	// columnHeadStyle.setBorderLeft((short) 1);// 边框的大小
	// columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
	// columnHeadStyle.setBorderRight((short) 1);// 边框的大小
	// columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //
	// 设置单元格的边框为粗体
	// columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); //
	// 设置单元格的边框颜色
	// // 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
	// columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
	//
	// HSSFFont font = workbook.createFont();
	// font.setFontName("宋体");
	// font.setFontHeightInPoints((short) 10);
	// // 普通单元格样式
	// HSSFCellStyle style = workbook.createCellStyle();
	// style.setFont(font);
	// style.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居中
	// style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);// 上下居中
	// style.setWrapText(true);
	// style.setLeftBorderColor(HSSFColor.BLACK.index);
	// style.setBorderLeft((short) 1);
	// style.setRightBorderColor(HSSFColor.BLACK.index);
	// style.setBorderRight((short) 1);
	// style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
	// style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
	// style.setFillForegroundColor(HSSFColor.WHITE.index);// 设置单元格的背景颜色．
	// // 另一个样式
	// HSSFCellStyle centerstyle = workbook.createCellStyle();
	// centerstyle.setFont(font);
	// centerstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	// centerstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	// centerstyle.setWrapText(true);
	// centerstyle.setLeftBorderColor(HSSFColor.BLACK.index);
	// centerstyle.setBorderLeft((short) 1);
	// centerstyle.setRightBorderColor(HSSFColor.BLACK.index);
	// centerstyle.setBorderRight((short) 1);
	// centerstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
	// centerstyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
	// centerstyle.setFillForegroundColor(HSSFColor.WHITE.index);// 设置单元格的背景颜色．
	//
	// try {
	// // 创建第一行
	// HSSFRow row0 = sheet.createRow(0);
	// // 设置行高
	// row0.setHeight((short) 900);
	// // 创建第一列
	// HSSFCell cell0 = row0.createCell(0);
	// cell0.setCellValue(new HSSFRichTextString("中非发展基金投资项目调度会工作落实情况对照表"));
	// cell0.setCellStyle(headstyle);
	// /**
	// * 合并单元格
	// * 第一个参数：第一个单元格的行数（从0开始）
	// * 第二个参数：第二个单元格的行数（从0开始）
	// * 第三个参数：第一个单元格的列数（从0开始）
	// * 第四个参数：第二个单元格的列数（从0开始）
	// */
	// CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
	// sheet.addMergedRegion(range);
	// // 创建第二行
	// HSSFRow row1 = sheet.createRow(1);
	// HSSFCell cell1 = row1.createCell(0);
	// cell1.setCellValue(new
	// HSSFRichTextString("本次会议时间：2009年8月31日       前次会议时间：2009年8月24日"));
	// cell1.setCellStyle(centerstyle);
	// // 合并单元格
	// range = new CellRangeAddress(1, 2, 0, 7);
	// sheet.addMergedRegion(range);
	// // 第三行
	// HSSFRow row2 = sheet.createRow(3);
	// row2.setHeight((short) 750);
	// HSSFCell cell = row2.createCell(0);
	// cell.setCellValue(new HSSFRichTextString("责任者"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(1);
	// cell.setCellValue(new HSSFRichTextString("成熟度排序"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(2);
	// cell.setCellValue(new HSSFRichTextString("事项"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(3);
	// cell.setCellValue(new HSSFRichTextString("前次会议要求\n/新项目的项目概要"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(4);
	// cell.setCellValue(new HSSFRichTextString("上周工作进展"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(5);
	// cell.setCellValue(new HSSFRichTextString("本周工作计划"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(6);
	// cell.setCellValue(new HSSFRichTextString("问题和建议"));
	// cell.setCellStyle(columnHeadStyle);
	// cell = row2.createCell(7);
	// cell.setCellValue(new HSSFRichTextString("备 注"));
	// cell.setCellStyle(columnHeadStyle);
	// // 访问数据库，得到数据集
	// List<DeitelVO> deitelVOList = getEntityManager().queryDeitelVOList();
	// int m = 4;
	// int k = 4;
	// for (int i = 0; i < deitelVOList.size(); i++) {
	// DeitelVO vo = deitelVOList.get(i);
	// String dname = vo.getDname();
	// List<Workinfo> workList = vo.getWorkInfoList();
	// HSSFRow row = sheet.createRow(m);
	// cell = row.createCell(0);
	// cell.setCellValue(new HSSFRichTextString(dname));
	// cell.setCellStyle(centerstyle);
	// // 合并单元格
	// range = new CellRangeAddress(m, m + workList.size() - 1, 0, 0);
	// sheet.addMergedRegion(range);
	// m = m + workList.size();
	//
	// for (int j = 0; j < workList.size(); j++) {
	// Workinfo w = workList.get(j);
	// // 遍历数据集创建Excel的行
	// row = sheet.getRow(k + j);
	// if (null == row) {
	// row = sheet.createRow(k + j);
	// }
	// cell = row.createCell(1);
	// cell.setCellValue(w.getWnumber());
	// cell.setCellStyle(centerstyle);
	// cell = row.createCell(2);
	// cell.setCellValue(new HSSFRichTextString(w.getWitem()));
	// cell.setCellStyle(style);
	// cell = row.createCell(3);
	// cell.setCellValue(new HSSFRichTextString(w.getWmeting()));
	// cell.setCellStyle(style);
	// cell = row.createCell(4);
	// cell.setCellValue(new HSSFRichTextString(w.getWbweek()));
	// cell.setCellStyle(style);
	// cell = row.createCell(5);
	// cell.setCellValue(new HSSFRichTextString(w.getWtweek()));
	// cell.setCellStyle(style);
	// cell = row.createCell(6);
	// cell.setCellValue(new HSSFRichTextString(w.getWproblem()));
	// cell.setCellStyle(style);
	// cell = row.createCell(7);
	// cell.setCellValue(new HSSFRichTextString(w.getWremark()));
	// cell.setCellStyle(style);
	// }
	// k = k + workList.size();
	// }
	// // 列尾
	// int footRownumber = sheet.getLastRowNum();
	// HSSFRow footRow = sheet.createRow(footRownumber + 1);
	// HSSFCell footRowcell = footRow.createCell(0);
	// footRowcell.setCellValue(new
	// HSSFRichTextString("                    审  定：XXX      审  核：XXX     汇  总：XX"));
	// footRowcell.setCellStyle(centerstyle);
	// range = new CellRangeAddress(footRownumber + 1, footRownumber + 1, 0, 7);
	// sheet.addMergedRegion(range);
	//
	// HttpServletResponse response = getResponse();
	// HttpServletRequest request = getRequest();
	// String filename = "未命名.xls";//设置下载时客户端Excel的名称
	// // 请见：http://zmx.iteye.com/blog/622529
	// filename = Util.encodeFilename(filename, request);
	// response.setContentType("application/vnd.ms-excel");
	// response.setHeader("Content-disposition", "attachment;filename=" +
	// filename);
	// OutputStream ouputStream = response.getOutputStream();
	// workbook.write(ouputStream);
	// ouputStream.flush();
	// ouputStream.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}
