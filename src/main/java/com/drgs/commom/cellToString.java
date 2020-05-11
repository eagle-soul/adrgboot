package com.drgs.commom;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cellToString {

    /**
     * @author SHUN
     * @param cell  import org.apache.poi.ss.usermodel.Cell;
     * 关于如何将Excel表格中的时间字符串的数字格式  转换成 格式化的时间字符串
     * @return
     */
    public static String excelTime(Cell cell) {
        String guarantee_time = null;
//        CellType cellType = cell.getCellTypeEnum();
//        if (DateUtil.isCellDateFormatted(cell)) {
            //用于转化为日期格式
        Date d = cell.getDateCellValue();
//	             System.err.println(d.toString());
//	             DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formater = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        guarantee_time = formater.format(d);
//        }
        return guarantee_time;
    }
}
