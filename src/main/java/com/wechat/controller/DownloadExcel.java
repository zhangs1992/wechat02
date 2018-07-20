package com.wechat.controller;


import com.wechat.bean.Mem;

import com.wechat.dao.MemRepository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Youchang Xu
 * @Description:
 * @Date: created in 14:29 2018/7/14
 * @Modified By:
 */
public class DownloadExcel {


    public  void writeEmployeeListToExcel( List<Mem> memList, String filename, HttpServletResponse response){
        System.out.println("开始写入文件>>>>>>>>>>>>");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("infomation");
        int rowIndex = 0;//标识位，用于标识sheet的行号
        //遍历数据集，将其写入excel中
        String[] title={"类别","旅客姓名","证件号","性别","年龄","票号","微信ID","联系方式","子女或亲友联系方式（必填项","住所（便于安排接送机，请具体至小区",
                "机上座位等其他要求（靠窗、几人坐在一起等","办事处","旅客地域","旅客来源（组团社/地接社名称","餐食要求（请从餐食可选内容中选择","餐食可选内容","所属群聊"};
        try{
            //写表头数据
            Row titleRow = sheet.createRow(rowIndex);
            for (int i = 0; i < title.length; i++) {
                //创建表头单元格,填值
                titleRow.createCell(i).setCellValue(title[i]);
            }
            System.out.println("表头写入完成>>>>>>>>");
            rowIndex++;
            //循环写入主表数据
            for (Iterator<Mem> memIter = memList.iterator(); memIter.hasNext();) {
                Mem employee = memIter.next();
                //create sheet row
                Row row = sheet.createRow(rowIndex);
                //create sheet coluum(单元格)
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(employee.getCategory());
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(employee.getName());
                Cell cell15 =row.createCell(2);
                cell15.setCellValue(employee.getIdCard());
                Cell cell16 =row.createCell(3);
                cell16.setCellValue(employee.getSex());
                Cell cell2 = row.createCell(4);
                cell2.setCellValue(employee.getAge());
                Cell cell3 = row.createCell(5);
                cell3.setCellValue(employee.getTicketNum());
                Cell cell4 = row.createCell(6);
                cell4.setCellValue(employee.getWeChatId());
                Cell cell5 = row.createCell(7);
                cell5.setCellValue(employee.getContact());
                Cell cell6 =row.createCell(8);
                cell6.setCellValue(employee.getChildContact());
                Cell cell7 =row.createCell(9);
                cell7.setCellValue(employee.getResidence());
                Cell cell8 =row.createCell(10);
                cell8.setCellValue(employee.getSeatRequirements());
                Cell cell9 =row.createCell(11);
                cell9.setCellValue(employee.getOffice());
                Cell cell10 =row.createCell(12);
                cell10.setCellValue(employee.getPassengerRegion());
                Cell cell11 =row.createCell(13);
                cell11.setCellValue(employee.getPassengerSource());
                Cell cell12 =row.createCell(14);
                cell12.setCellValue(employee.getFoodRequirements());
                Cell cell13 =row.createCell(15);
                cell13.setCellValue(employee.getMealOptionalContent());
                Cell cell14 =row.createCell(16);
                cell14.setCellValue(employee.getChatroom());

                rowIndex++;
            }
            System.out.println("主表数据写入完成>>>>>>>>");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
            System.out.println("写入文件成功>>>>>>>>>>>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
