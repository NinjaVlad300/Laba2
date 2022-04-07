package com.company;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    public void Writing(Calculater C, String st) throws IOException {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Романенков");

        sheet.setColumnWidth(0, 6500);

        XSSFRow row0 = sheet.createRow(0);
        row0.createCell(1, CellType.STRING).setCellValue("X");
        row0.createCell(2, CellType.STRING).setCellValue("Y");
        row0.createCell(3, CellType.STRING).setCellValue("Z");


        int i = 1;
        for (Object str : C.lhm().keySet()) {
            XSSFRow row = sheet.createRow(i);
            row.createCell(0, CellType.STRING).setCellValue((String) str);
            for (int k = 0; k < 3; k++) {
                row.createCell(k + 1, CellType.NUMERIC).setCellValue(C.lhm().get(str)[k]);
            }
            i++;
        }

        File file = new File(st);
        wb.write(new FileOutputStream(file));
        wb.close();

    }}
