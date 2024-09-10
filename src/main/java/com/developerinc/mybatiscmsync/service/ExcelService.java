package com.developerinc.mybatiscmsync.service;

import com.developerinc.mybatiscmsync.model.EmailAttachData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExcelService {

    @Autowired
    private  EmailAttachDataService emailAttachDataService;





    public void getExcelData() {

        System.out.println("Generating Excel file...");

        try {
            generateExcel();
        } catch (IOException e) {
            System.out.println("Error generating Excel file: " + e.getMessage());
        }
    }

    public void generateExcel() throws IOException {

        List<EmailAttachData> emailAttachData = emailAttachDataService.getAllEmailAttachData();

        File file = new File("target/classes/example.xlsx");




        System.out.println("Start wookbook...");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Example Sheet");

        AtomicInteger data_row = new AtomicInteger(0);

        // Create header row
        Row headerRow = sheet.createRow(data_row.getAndIncrement());
        Cell headerCell = headerRow.createCell(0);

        headerCell.setCellValue("ACTIVE DATE");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("LAST NAME");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("FIRST NAME");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("ADDRESS LINE 1");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("LINE2");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("CITY");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("STATE");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("ZIP");
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("CELLPHONE");
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("HOME PHONE");
        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("HOME PT KIT");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerCell.setCellStyle(headerStyle);

        emailAttachData.stream()
                .forEach(t -> {


                    System.out.println(t.getActiveDate() + " " + data_row);
                    Row dataRow = sheet.createRow(data_row.getAndIncrement());

                    CellStyle style = workbook.createCellStyle();
                    // create a DataFormat object
                    DataFormat format = workbook.createDataFormat();
                    style.setDataFormat(format.getFormat("dd-MMM-yy")); Cell dataCell = dataRow.createCell(0);

                    dataCell.setCellValue(DateUtil.getExcelDate(t.getActiveDate()));
                    dataCell.setCellStyle(style);
                    dataCell = dataRow.createCell(1);
                    dataCell.setCellValue(t.getLastName());
                    dataCell = dataRow.createCell(2);
                    dataCell.setCellValue(t.getFirstName());
                    dataCell = dataRow.createCell(3);
                    dataCell.setCellValue(t.getAddress1());
                    dataCell = dataRow.createCell(4);
                    dataCell.setCellValue(t.getAddress2());
                    dataCell = dataRow.createCell(5);
                    dataCell.setCellValue(t.getCity());
                    dataCell = dataRow.createCell(6);
                    dataCell.setCellValue(t.getState());
                    dataCell = dataRow.createCell(7);
                    dataCell.setCellValue(t.getZip());
                    dataCell = dataRow.createCell(8);
                    dataCell.setCellValue(t.getCellphone());
                    dataCell = dataRow.createCell(9);
                    dataCell.setCellValue(t.getHomephone());
                    dataCell = dataRow.createCell(10);
                    dataCell.setCellValue(t.getHomeptkit());
                });

        // Create data rows


        System.out.println("Finished wookbook...");

        // Style the header row


//        emailAttachData.stream()
//                .forEach(t -> fillSheetData(sheet,data_row.addAndGet(1),t));



        // Write the workbook to a byte array
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //workbook.write(bos);
        //bos.close();

        // Write the workbook to a file
        try {

            if(file.exists()){
                file.delete();
            }


            FileOutputStream fos = new FileOutputStream("target/classes/example.xlsx");
            workbook.write(fos);
            fos.close();

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Workbook created successfully.");
    }



}
