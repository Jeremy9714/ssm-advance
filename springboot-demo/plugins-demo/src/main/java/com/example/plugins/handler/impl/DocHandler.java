package com.example.plugins.handler.impl;

import com.example.plugins.bean.DocBean;
import com.example.plugins.handler.DataInfoBaseHandler;
import com.example.plugins.service.DocService;
import com.example.plugins.util.EnumConverter;
import com.example.plugins.util.ExcelUtils;
import com.example.plugins.util.GlobalUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 10:07
 * @Version: 1.0
 */
@Component
public class DocHandler extends DataInfoBaseHandler {

    @Autowired
    private DocService docService;

    @Override
    public void exportDataExcel(HttpServletResponse response) {
        List<String> sheetNames = new ArrayList<>();
//        sheetNames.add("doc首页");
        sheetNames.add("doc_tbl信息");

        List<List<String>> excelDataList = getExcelData();
        ExcelUtils.writeExcel(response, "数据导出", sheetNames, excelDataList);
    }

    @Override
    public void importDataExcel(MultipartFile file) {
        if (file == null) {
            throw new RuntimeException("文件为空");
        }

        String fileName = file.getOriginalFilename();
        if (!ExcelUtils.isExcel2003(fileName) && !ExcelUtils.isExcel2007(fileName)) {
            throw new RuntimeException("文件非Excel格式");
        }

        long size = file.getSize();
        InputStream is = null;
        Workbook wb = null;
        Sheet sheet = null;

        try {
            is = file.getInputStream();
            if (ExcelUtils.isExcel2003(fileName)) {
                wb = new HSSFWorkbook(is);
            } else if (ExcelUtils.isExcel2007(fileName)) {
                wb = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            System.out.println("Excel创建失败，" + e.getMessage());
        }

        if (wb != null && wb.getNumberOfSheets() > 0) {
            sheet = wb.getSheetAt(0);
        }

        if (size == 0 || sheet == null || sheet.getLastRowNum() == 0) {
            throw new RuntimeException("文件为空");
        }

        // 校验表头
        Row row = sheet.getRow(0);
        int cellSize = row.getLastCellNum();
        Iterator<Cell> iterator = row.cellIterator();
        final String[] headCells = {"姓名", "性别", "年龄", "地址", "职业"};
        if (cellSize == headCells.length) {
            for (int i = 0; iterator.hasNext(); ++i) {
                if (!headCells[i].equals(iterator.next().getStringCellValue())) {
                    throw new RuntimeException("格式错误");
                }
            }
        } else {
            throw new RuntimeException("格式错误");
        }

        executeImport(sheet);
    }

    private void executeImport(Sheet sheet) {
        // 校验格式
        verifySheet(sheet);

        // 保存数据
        List<DocBean> docBeans = new ArrayList<>();
        for (int r = 1; r <= sheet.getLastRowNum(); ++r) {
            Row row = sheet.getRow(r);
            if (row == null || !row.cellIterator().hasNext()) {
                continue;
            }

            for (int i = 0; i < row.getLastCellNum(); ++i) {
                Cell cell = row.getCell(i);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                }
            }

            DocBean.DocBeanBuilder builder = DocBean.builder();
            String name = row.getCell(0).getStringCellValue();
            String gender = row.getCell(1).getStringCellValue();
            String age = row.getCell(2).getStringCellValue();
            String address = row.getCell(3).getStringCellValue();
            String job = row.getCell(4).getStringCellValue();

            DocBean doc = builder.id(GlobalUtils.getUUID())
                    .name(name)
                    .age(Integer.valueOf(age))
                    .gender(EnumConverter.convertGender(gender))
                    .address(address)
                    .job(EnumConverter.convertJob(job))
                    .build();
            docBeans.add(doc);
        }

        docService.saveBatch(docBeans);
    }

    /**
     * 校验表单格式
     *
     * @param sheet
     */
    private void verifySheet(Sheet sheet) {
        for (int i = 1; i < sheet.getLastRowNum(); ++i) {
            Row row = sheet.getRow(i);
            if (row == null || !row.cellIterator().hasNext()) {
                continue;
            }

            // 设置单元格格式
            for (int j = 0; j < row.getLastCellNum(); ++j) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                }
            }

            Cell cell1 = row.getCell(0);
            if (cell1 == null || StringUtils.isBlank(cell1.getStringCellValue())) {
                throw new RuntimeException("第" + (i + 1) + "行“姓名” 不能为空");
            }
            Cell cell2 = row.getCell(0);
            if (cell2 == null || StringUtils.isBlank(cell2.getStringCellValue())) {
                throw new RuntimeException("第" + (i + 1) + "行“性别” 不能为空");
            }
            Cell cell3 = row.getCell(0);
            if (cell3 == null || StringUtils.isBlank(cell3.getStringCellValue())) {
                throw new RuntimeException("第" + (i + 1) + "行“年龄” 不能为空");
            }
            Cell cell4 = row.getCell(0);
            if (cell4 == null || StringUtils.isBlank(cell4.getStringCellValue())) {
                throw new RuntimeException("第" + (i + 1) + "行“地址” 不能为空");
            }
            Cell cell5 = row.getCell(0);
            if (cell5 == null || StringUtils.isBlank(cell5.getStringCellValue())) {
                throw new RuntimeException("第" + (i + 1) + "行“职业” 不能为空");
            }
        }
    }
}
