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
    public String[] getParamNames(){
        String paramNames[] = new String[11];
        int counter = 0;
        for (int i = 0; i < paramNames.length-1; i++){
            paramNames[i] = getData(1, i+1);
            if (paramNames[i].equals("-")){
                counter++;
            }
        }
        paramNames[10] = Integer.toString(paramNames.length - counter - 1);
        return paramNames;
    }
    public String[] getParamErrors(){
        String paramErrors[] = new String[11];
        int counter = 0;
        for (int i = 0; i < paramErrors.length-1; i++){
            try {
                paramErrors[i] = Double.toString(getData(0, i+1));
            } catch(Exception e){
                paramErrors[i] = "-";
            }
            if (paramErrors[i].equals("-")){
                counter++;
            }
            
        }
        paramErrors[10] = Integer.toString(paramErrors.length - counter - 1);
        return paramErrors;
    }
    public <T> T getData(int row, int column){
        T answer = null;
        try {
            InputStream excelFile = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(excelFile);
            Sheet sheet = wb.getSheetAt(0);
            Row roww = sheet.getRow(row);
            Cell cell = roww.getCell(column);
            if (cell.getCellType() == CellType.NUMERIC){
                answer = (T) Double.valueOf(cell.getNumericCellValue());
            } else if (cell.getCellType() == CellType.STRING){
                answer = (T) cell.getStringCellValue();
            } else {
                answer = (T) "-";
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return answer;
    }
}
