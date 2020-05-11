package com.drgs.commom;

import com.drgs.commom.ZTBGyUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExcelImportUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelImportUtil.class);

    /**
     * 根据传入文件，返回Excel流对象
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook readExcel(MultipartFile file) throws IOException {
        //文件后缀名
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        InputStream is = null;
        try {
            is = file.getInputStream();
            if(".xls".equals(fileExt)){
                try {
                    return new HSSFWorkbook(is);
                }catch(Exception ex) {
                    logger.error("ExcelImportUtil|readExcel|ex="+ex);
                    return null;
                }
            }else if(".xlsx".equals(fileExt)){
                return new XSSFWorkbook(is);
            }else{
                is.close();
                return null;
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                is.close();
            }
        }
        return null;
    }

    /**
     * 获取单元格格式，返回String类型
     * @param cell
     * @return
     */
    /*
     * public static String getCellFormatStr(Cell cell){ SimpleDateFormat sdf = new
     * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String cellValue = null; if(cell !=
     * null){ //判断cell类型 switch(cell.getCellType()){ case
     * Cell.CELL_TYPE_NUMERIC:{//是否为数值类型 String formatStr =
     * cell.getCellStyle().getDataFormatString(); short format =
     * cell.getCellStyle().getDataFormat();
     * //判断cell是否为日期格式=读出是规定格式||是日期格式||format大于0并且不是百分比
     * if("m/d/yy".equals(formatStr) || DateUtil.isCellDateFormatted(cell) ||
     * (format > 0 && !formatStr.endsWith("%"))){ //转换为日期格式yyyy-MM-dd HH:mm:ss Date
     * date = (Date) cell.getDateCellValue(); cellValue = sdf.format(date); } else {
     * cellValue =String.valueOf(cell.getNumericCellValue());//数字，为double类型 } break;
     * } } }else{ cellValue = ""; } return cellValue; }
     */
    /**
     * 根据传入的规则，校验传入值并返回相应类型的值，校验失败的抛出异常
     * @param cellFormatStr
     * @param cls
     * @return
     */
    public static Object validateValue(String cellFormatStr, Class<?> cls){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //如果大于15，说明有可能是带有时间格式的日期
            if(cellFormatStr.length() > 15) {
                return sdfTime.parse(cellFormatStr);
            }else if(cellFormatStr.indexOf("/")>-1){
                return sdf1.parse(cellFormatStr);
            }else{
                return sdf2.parse(cellFormatStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellFormatStr;
    }

    public static Map<String, Object> validateExcelType(MultipartFile file) {

        Map<String, Object> map =new HashMap<String, Object>();
        Boolean flag =true;
        if(file ==null || ZTBGyUtils.isNull(file.getOriginalFilename()) || file.getOriginalFilename().length() <=0) {
            flag =false;
            map.put("flag", flag);
            map.put("msg", "文件为空");
            return map;
        }

        String hz = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if(!(".xls").equals(hz)) {
            flag =false;
            map.put("flag", flag);
            map.put("msg", "文件格式必须为'.xls'");
            return map;
        }
        map.put("flag", flag);
        return map;
    }

}
