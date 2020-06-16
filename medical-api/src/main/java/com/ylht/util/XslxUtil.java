package com.ylht.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XslxUtil {
    public List<List> readXlsx(InputStream inputFile) {
        List<List> dataList = new ArrayList();
        try {
            // Get the workbook instance for XLSX file
            XSSFWorkbook wb = new XSSFWorkbook(inputFile);

            // Get first sheet from the workbook
            XSSFSheet sheet = wb.getSheetAt(0);

            Row row;
            Cell cell;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            int rowNum = 0;
            while (rowIterator.hasNext()) {
                rowNum++;
                List<Object> list = new ArrayList();
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int colNum = 0;
                while (cellIterator.hasNext()) {
                    colNum++;
                    cell = cellIterator.next();
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_BOOLEAN:
                            list.add(cell.getBooleanCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            list.add(cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_STRING:
                            list.add(cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            list.add("");
                            break;

                        default:
                            list.add(cell);
                    }

                }
                dataList.add(list);
            }

        } catch (Exception e) {
            System.err.println("Exception :" + e.getMessage());
        }
        return dataList;
    }


    public void writeExcel(List<List> list, File file) throws FileNotFoundException {
        //创建工作簿
        FileOutputStream outputStream = new FileOutputStream(file);
        XSSFWorkbook xssfWorkbook = null;
        xssfWorkbook = new XSSFWorkbook();

        //创建工作表
        XSSFSheet xssfSheet;
        xssfSheet = xssfWorkbook.createSheet();

        //创建行
        XSSFRow xssfRow;

        //创建列，即单元格Cell
        XSSFCell xssfCell;

        //把List里面的数据写到excel中
        for (int i = 0; i < list.size(); i++) {
            //从第一行开始写入
            xssfRow = xssfSheet.createRow(i);
            //创建每个单元格Cell，即列的数据
            List sub_list = list.get(i);
            for (int j = 0; j < sub_list.size(); j++) {
                xssfCell = xssfRow.createCell(j); //创建单元格
                xssfCell.setCellValue(sub_list.get(j).toString()); //设置单元格内容
            }
        }

        //用输出流写到excel
        try {
            xssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
