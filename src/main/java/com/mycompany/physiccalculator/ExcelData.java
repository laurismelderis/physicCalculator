package com.mycompany.physiccalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
    private String fileName = "";
    public ExcelData(String fileName){
        this.fileName = fileName;
    }
    public double[] getColumnData(int column, int rowCount){
        double arr[] = new double[rowCount];
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            int counter = 0;
            for (int i = 2; i < 27; i++){
                Row row = sheet.getRow(i);
                try {
                    Cell cell = row.getCell(column);
                    if (cell.getCellType() == CellType.NUMERIC){
                        arr[counter] = cell.getNumericCellValue();
                        counter++;
                    }
                } catch (Exception e){
                
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return arr;
    }
    public int getColumnCount(){
        int count = 0;
        for (int column = 1; column < 11; column++){
            double data[] = getColumnData(column, getRowCount(column));
            if (data.length != 0){
                count++;
            }
        }
        return count;
    }
    public int getRowCount(int column){
        int counter = 0;
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 2; i < 27; i++){
                try {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(column);
                    if (cell.getCellType() == CellType.NUMERIC){
                        counter++;
                    } else {
                        continue;
                    }
                } catch (Exception e){
                
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return counter;
    }
    public boolean isParamName(){
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(1);
            for (int i = 1; i < 11; i++){
                try {
                    Cell cell = row.getCell(i);
                    if (cell.getCellType() == CellType.STRING || cell == null){
                        continue;
                    } else {
                        return false;
                    }
                } catch (Exception e){
                    continue;
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }
    public double getData(int row, int column){
        double answer = 0;
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            Row roww = sheet.getRow(row);
            Cell cell = roww.getCell(column);
            answer = cell.getNumericCellValue();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return answer;
    }
}
