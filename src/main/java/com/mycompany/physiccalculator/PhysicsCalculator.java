package com.mycompany.physiccalculator;

import java.util.Scanner;
import org.apache.poi.ss.usermodel.Workbook;

public class PhysicsCalculator{
    public static void main(String[] args) {
//        new MainFrame().setVisible(true);
        String file = "C:\\Users\\User\\Documents\\ey";
        ExcelData excelData = new ExcelData(file);
        excelData.writeData(file, 0, 0, "hello excel");
    }
    public static <T> void print(T print){
        System.out.printf("%s \t", print);
    }
}
