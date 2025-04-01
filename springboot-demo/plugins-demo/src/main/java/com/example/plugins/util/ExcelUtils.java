package com.example.plugins.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 10:04
 * @Version: 1.0
 */
public class ExcelUtils {

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlxs)$");
    }

    /**
     * 写入excel
     *
     * @param response
     * @param fileName
     * @param sheetNames
     * @param dataLists
     * @param <T>
     */
    public static <T> void writeExcel(HttpServletResponse response, String fileName, List<String> sheetNames, List<List<String>>... dataLists) {
        // excel 2007
        Workbook wb = new XSSFWorkbook();

        // 表头格式
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);

        // 表头样式
        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        cellStyle.setFont(font);

        // 封装表单
        for (int i = 0; i < sheetNames.size(); ++i) {
            String sheetName = sheetNames.get(i);
            List<List<String>> dataList = dataLists[i];
            // 创建表单
            Sheet sheet = wb.createSheet(sheetName);
            AtomicInteger ai = new AtomicInteger();
            for (int j = 0; j < dataList.size(); ++j) {
                // 创建行
                Row row = sheet.createRow(ai.getAndIncrement());
                AtomicInteger aj = new AtomicInteger();
                List<String> rowData = dataList.get(j);
                rowData.forEach(data -> {
                    // 创建单元格
                    Cell cell = row.createCell(aj.getAndIncrement());
                    // 表头样式配置
                    if (ai.get() == 1) {
                        cell.setCellStyle(cellStyle);
                    }
                    cell.setCellValue(data);
                });
            }
        }

        buildExcelDocument(fileName + ".xlsx", wb, response);
    }

    public static void buildExcelDocument(String fileName, Workbook wb, HttpServletResponse response) {
        try {
            // application/octet-stream 二进制流，浏览器开始下载
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            // Content-Disposition 指定下载格式
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            response.flushBuffer();
            wb.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("导出失败，" + e.getMessage());
        }
    }
}
