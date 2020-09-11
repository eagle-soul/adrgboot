package com.drgs.disease.controller;

import com.drgs.commom.ChineseToFirstLetterUtil;
import com.drgs.disease.service.DiseaseService;
import com.drgs.vo.JsonResult;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

@RequestMapping("/disease")
@CrossOrigin
@RestController
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping("/importDiseaseData")
    public JsonResult importDiseaseData(@RequestParam("file")MultipartFile[] fileList) throws Exception {
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(diseaseService.importDiseaseData(fileList));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(diseaseService.importDiseaseData(fileList));
        }
        return jsonResult;
    }

    @RequestMapping("/importMDCData")
    public JsonResult importMCDData(@RequestParam("file")MultipartFile[] fileList) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(diseaseService.importMDCData(fileList));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(diseaseService.importMDCData(fileList));
        }
        return jsonResult;
    }

    @RequestMapping("/getDiseaseList")
    public JsonResult getDiseaseList(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getDiseaseList(params));

        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getDiseaseList(params));
        }
        return jsonResult;
    }

    @RequestMapping("/getDiseaseInfoByRecord")
    public JsonResult getDiseaseInfoByRecord(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getDiseaseInfoByRecord(params));

        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getDiseaseInfoByRecord(params));
        }
        return jsonResult;
    }
    @RequestMapping("/getMDCData")
    public JsonResult getMCDData(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getMCDData(params));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getMCDData(params));
        }
        return jsonResult;
    }

    @RequestMapping("/updateDiseaseNum")
    public JsonResult updateDiseaseNum() throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            diseaseService.updateDiseaseNum();
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
        }
        return jsonResult;
    }


    @RequestMapping("/exportTempExcel")
    public void exportTempExcel(HttpServletResponse response,
                                HttpServletRequest request) throws Exception{
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("投票组用户.xls", "utf-8"));
        OutputStream out = response.getOutputStream();
        Workbook wb = new HSSFWorkbook();;

        List<String> unitStr = new ArrayList<>();
        unitStr.add("kxld");
        unitStr.add("bgtj");
        unitStr.add("bgtc");
        for(String str:unitStr){
            int rowNum = 0;
            int cellNum = 0;
            Sheet sheet = wb.createSheet(str);
            printSetup(sheet);
            for (int i = 0;i < 8;i++){
                sheet.addMergedRegion(new CellRangeAddress(rowNum,rowNum,0,1));
                sheet.setColumnWidth(0,10235);
                sheet.setColumnWidth(1,10235);
                Row urlRow = sheet.createRow(rowNum++);
                Row row1 = sheet.createRow(rowNum++);
                Row row2 = sheet.createRow(rowNum++);
                Row row3 = sheet.createRow(rowNum);
                row3.setHeight((short)(1 * 600));
                Cell user = row1.createCell(cellNum);
                Cell password = row1.createCell(cellNum+1);
                Cell userCell = row2.createCell(cellNum);
                Cell passwordCell = row2.createCell(cellNum+1);
                Cell urlCell1 = urlRow.createCell(cellNum);
                Cell urlCell2 = urlRow.createCell(cellNum+1);
                user.setCellValue("帐号");
                password.setCellValue("密码");
                userCell.setCellValue(ChineseToFirstLetterUtil.getLoginNum(str));
                passwordCell.setCellValue(ChineseToFirstLetterUtil.getPassword());
                urlCell1.setCellValue("投票地址：http://210.14.113.28:802/vote");
                urlCell1.setCellStyle(urlStyle(wb,urlRow));
                urlCell2.setCellStyle(urlStyle(wb,urlRow));
                user.setCellStyle(userAndPwdStyle(wb,row1));
                password.setCellStyle(userAndPwdStyle(wb,row1));
                userCell.setCellStyle(userAndPwdStyle(wb,row2));
                passwordCell.setCellStyle(userAndPwdStyle(wb,row2));
                rowNum++;
            }
        }
        wb.write(out);
        out.flush();
    }

    private CellStyle urlStyle(Workbook wb,Row row){
        Font f = wb.createFont();
        short var1 = 1 * 600;
        row.setHeight(var1);
        f.setFontHeightInPoints((short) 14);// 字号
        f.setBold(true);
        f.setFontName("宋体");
        CellStyle urlStyle = wb.createCellStyle();
        urlStyle.setWrapText(true);// 自动换行
        urlStyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        urlStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        urlStyle.setBorderBottom(BorderStyle.THIN);
        urlStyle.setBorderRight(BorderStyle.THIN);
        urlStyle.setBorderTop(BorderStyle.THIN);
        urlStyle.setBorderLeft(BorderStyle.THIN);
        urlStyle.setFont(f);
        return urlStyle;
}


    private CellStyle userAndPwdStyle(Workbook wb,Row row){
        Font f = wb.createFont();
        short var1 = 1 * 600;
        row.setHeight(var1);
        f.setFontHeightInPoints((short) 14);// 字号
        f.setFontName("宋体");
        CellStyle urlStyle = wb.createCellStyle();
        urlStyle.setWrapText(true);// 自动换行
        urlStyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        urlStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        urlStyle.setBorderBottom(BorderStyle.THIN);
        urlStyle.setBorderRight(BorderStyle.THIN);
        urlStyle.setBorderTop(BorderStyle.THIN);
        urlStyle.setBorderLeft(BorderStyle.THIN);
        urlStyle.setFont(f);
        return urlStyle;
    }

    private void printSetup(Sheet sheet){
        HSSFPrintSetup hps=(HSSFPrintSetup) sheet.getPrintSetup();//获取页面的打印设置
        hps.setPaperSize((short) 9);//设置a4纸
        hps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);//设置a4纸
        hps.setFitHeight((short)10);//设置缩放为10行高
        hps.setFitWidth((short)9);//设置列宽
        hps.setLeftToRight(true);//设置打印顺序先行后列，默认为先列后行
        sheet.setHorizontallyCenter(true);//设置打印页面水平居中
    }

}
