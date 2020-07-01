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
    public int getColumnCount(){
        int counter = 0;
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(0);
            
            while (true){
                Cell cell = row.getCell(counter);
                if (cell == null || cell.getCellType() != CellType.NUMERIC){
                    break;
                }
                counter++;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return counter;
    }
    public int getRowCount(int column){
        int counter = 0;
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 0; i < 26; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(column);
                if (cell == null){
                    break;
                } else{
                    counter++;
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return counter;
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
