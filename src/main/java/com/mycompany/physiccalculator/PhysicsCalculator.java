package com.mycompany.physiccalculator;

public class PhysicsCalculator{
    public static void main(String[] args) {
        new MainFrame().setVisible(true);

//        String fileName = "C:\\Users\\User\\Documents\\example.xlsx";
//        ExcelData excelData = new ExcelData(fileName);
//        String errors[] = excelData.getParamErrors();
//        for (int i = 0; i < errors.length; i++){
//            System.out.println(errors[i]);
//        }
        
    }
    public static <T> void print(T print){
        System.out.printf("%s \t", print);
    }
}
