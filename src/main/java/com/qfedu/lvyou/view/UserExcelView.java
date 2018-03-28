package com.qfedu.lvyou.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.qfedu.lvyou.model.User;

@Component("userExcelView")
public class UserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 0.获取用户数据
		List<User> users =(List<User>)model.get("users");
		// 1.获取模板，并解析
		File fileTmpl = ResourceUtils.getFile("classpath:template/user-template.xlsx");
		// 1.1.解析模板Workbook
		Workbook bookTmpl = null;
		bookTmpl = new XSSFWorkbook (new FileInputStream(fileTmpl));
		// 1.2.解析模板sheet
		Sheet sheetTmpl = bookTmpl.getSheetAt(0);
		// 1.3.解析模板sheet的标题行
		Row rowHeaderTmpl = sheetTmpl.getRow(0);
		// 1.4.解析模板sheet的数据行
		Row rowDataTmpl = sheetTmpl.getRow(1);
		// 2.按照模板创建book中的sheet/row/cell
		// 2.1.创建sheet
		Sheet sheet = book.createSheet(sheetTmpl.getSheetName());
		for (int i = 0; i < rowHeaderTmpl.getLastCellNum(); i ++) {
			sheet.setColumnWidth(i, sheetTmpl.getColumnWidth(i));
		}
		// 2.2.创建标题行
		Row rowHeader = createRowByTmpl(rowHeaderTmpl, sheet, 0, true);
		for (int i = 0; i < users.size(); i ++) {
			User u = users.get(i);
			Row rowData = createRowByTmpl(rowDataTmpl, sheet, i + 1, false);
			rowData.getCell(0).setCellValue(u.getId());
			rowData.getCell(1).setCellValue(u.getLoginName());
			if (u.getCreateTime() != null) {
				rowData.getCell(2).setCellValue(u.getCreateTime());
			}
		}
	}
	
	/**
	 * 根据tmpl在sheetTarget上第row行创建目标行
	 * @param tmpl
	 * @param sheetTarget
	 * @param row
	 * @param setValue
	 * @return
	 */
	private Row createRowByTmpl (Row tmpl, Sheet sheetTarget, int row, Boolean setValue) {
		// 创建目标行
		Row rowTarget = sheetTarget.createRow(row);
		// 设置高度
		rowTarget.setHeight(tmpl.getHeight());
		// 根据tmpl为目标行创建cell
		for (int i = 0; i < tmpl.getLastCellNum(); i ++) {
			// 为目标行创建单元格
			Cell cellTarget = rowTarget.createCell(i);
			// 将模板单元格tmpl.getCell(i)克隆岛目标单元格cellTarget上
			cloneCell (tmpl.getCell(i), cellTarget, setValue);
		}
		return rowTarget;
	}
	
	/**
	 * 将tmpl的样式和值设置到target上
	 * @param tmpl
	 * @param target
	 * @param setValue 如果为true，表示需要设置值，否则不必
	 */
	private void cloneCell (Cell tmpl, Cell target, Boolean setValue) {
		// 设置目标单元格类型
		target.setCellType(tmpl.getCellTypeEnum());
		// 设置目标单元格批注
		target.setCellComment(tmpl.getCellComment());
		if (!setValue) {
			return;
		}
		switch (tmpl.getCellTypeEnum()) {
		case BOOLEAN :
			target.setCellValue(tmpl.getBooleanCellValue());
			break;
		case NUMERIC :
			target.setCellValue(tmpl.getNumericCellValue());
			break;
		default:
			target.setCellValue(tmpl.getStringCellValue());
		}
	}

}
