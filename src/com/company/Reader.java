package com.company;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    public ArrayList<double[]> Reading(String st) throws IOException {

        //10 вариант
        //st = "C:\\Влад\\Мифи\\java\\ДЗ2.xlsx"

        XSSFWorkbook wb = new XSSFWorkbook(st);
        XSSFSheet sheet = wb.getSheetAt(9);


        ArrayList<double[]> ArrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            double[] arr = new double[(sheet).getLastRowNum()];
            for (int k = 1; k <= sheet.getLastRowNum(); k++) {
                arr[k - 1] = sheet.getRow(k).getCell(i).getNumericCellValue();
            }

            ArrayList.add(arr);
        }
        wb.close();

        return ArrayList;
    }

}
