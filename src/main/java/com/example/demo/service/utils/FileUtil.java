package com.example.demo.service.utils;

import com.example.demo.entity.form.Form6v1;
import com.example.demo.entity.form.Form7v1;
import com.example.demo.entity.form.SubForm;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @create_at 17-11-3
 **/
public class FileUtil {
    private InputStream file;
    public FileUtil(String path)throws Exception{
        this.file=new FileInputStream(new File(path));
    }
    public FileUtil(MultipartFile file)throws Exception{
        this.file=file.getInputStream();
    }
    public List<SubForm> excel2lists()throws Exception{

        Workbook wb= WorkbookFactory.create(file);
        List<SubForm> list=new ArrayList<>();

        Sheet sheet=wb.getSheetAt(0);
        for(Row row:sheet){
            for(int i=0;i<13;i++){
                Cell cell=row.getCell(i);
                if(cell==null||cell.getCellTypeEnum()==CellType.BLANK){
                    Cell cell2=row.createCell(i);
                    cell2.setCellValue("---");
                }
                else{
                    cell.setCellType(CellType.STRING);}
            }
        }
        for(Row row:sheet){
            if(row.equals(sheet.getRow(0))){
                continue;
            }
            SubForm form7v1=new SubForm();
            form7v1.setIid(row.getRowNum());
            form7v1.setDeviceKind(row.getCell(1).getStringCellValue());
            form7v1.setEqCode(row.getCell(2).getStringCellValue());
            form7v1.setFillMedia(row.getCell(3).getStringCellValue());
            form7v1.setManufactureComName(row.getCell(4).getStringCellValue());
            form7v1.setEqCreateDate(row.getCell(5).getStringCellValue());
            form7v1.setWorkPressure(row.getCell(6).getStringCellValue());
            form7v1.setVolume(row.getCell(7).getStringCellValue());
            form7v1.setTestDate(row.getCell(8).getStringCellValue());
            form7v1.setNextTestDate(row.getCell(9).getStringCellValue());
            form7v1.setEqComCode(row.getCell(10).getStringCellValue());
            form7v1.setEqStatus(row.getCell(11).getStringCellValue());
            form7v1.setInfoMessage(row.getCell(12).getStringCellValue());
            list.add(form7v1);
        }
        return list;
    }
    public List<SubForm> excel2list2()throws Exception{

        Workbook wb= WorkbookFactory.create(file);
        List<SubForm> list=new ArrayList<>();

        Sheet sheet=wb.getSheetAt(0);
        for(Row row:sheet){
            for(int i=0;i<=17;i++){
                Cell cell=row.getCell(i);
            if(cell==null||cell.getCellTypeEnum()==CellType.BLANK){
                    Cell cell2=row.createCell(i);
                    cell2.setCellValue("---");
                }
            else{
                cell.setCellType(CellType.STRING);}
            }
        }
        for(Row row:sheet){
            if(row.equals(sheet.getRow(0))){
                continue;
            }
            SubForm form6v1=new SubForm();
            form6v1.setIid(row.getRowNum());
            form6v1.setPipeName(row.getCell(1).getStringCellValue());
            form6v1.setEqCode(row.getCell(2).getStringCellValue());
            form6v1.setEqLevel(row.getCell(3).getStringCellValue());
            form6v1.setDesignComName(row.getCell(4).getStringCellValue());
            form6v1.setConstructComName(row.getCell(5).getStringCellValue());
            form6v1.setEqCreateDate(row.getCell(6).getStringCellValue());
            form6v1.setEqUseDate(row.getCell(7).getStringCellValue());
            form6v1.setDiameter(row.getCell(8).getStringCellValue());
            form6v1.setThickness(row.getCell(9).getStringCellValue());
            form6v1.setLength(row.getCell(10).getStringCellValue());
            form6v1.setWorkPressure(row.getCell(11).getStringCellValue());
            form6v1.setTemperature(row.getCell(12).getStringCellValue());
            form6v1.setFillMedia(row.getCell(13).getStringCellValue());
            form6v1.setTestResult(row.getCell(14).getStringCellValue());
            form6v1.setTestComName(row.getCell(15).getStringCellValue());
            form6v1.setNextTestDate(row.getCell(16).getStringCellValue());
            form6v1.setRemark(row.getCell(17).getStringCellValue());
            list.add(form6v1);
        }
        return list;
    }

}
