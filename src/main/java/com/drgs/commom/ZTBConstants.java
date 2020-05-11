package com.drgs.commom;


public class ZTBConstants {


    //常用变量
    private static final String COMMON_STR_0 = "0";
    private static final String COMMON_STR_1 = "1";
    private static final String COMMON_STR_2 = "2";
    private static final String COMMON_STR_3 = "3";
    private static final String COMMON_STR_4 = "4";
    private static final String COMMON_STR_5 = "5";

    // 是否
    public static final String YES = "1";
    public static final String NO = "0";
    // 删除标志 0否1是
    public static final String DELETE_NO = "0";
    public static final String DELETE_YES = "1";

    public static final String PARAMETER = "检查参数";

    public static final String BC_SUCCESS = "保存成功";
    public static final String BC_FAIL = "保存失败";

    public static final String CX_SUCCESS = "查询成功";
    public static final String CX_FAIL = "查询失败";

    public static final String XG_SUCCESS = "修改成功";
    public static final String XG_FAIL = "修改失败";

    public static final String SC_SUCCESS = "删除成功";
    public static final String SC_FAIL = "删除失败";

    public static final String CZ_SUCCESS = "操作成功";
    public static final String CZ_FAIL = "操作失败";
    
    public static final String PARAM_NULL="参数为空";
    public static final String ID_NULL="主键为空";
    
    public static final String DR_SUCCESS = "导入成功";
    public static final String DR_FAIL = "导入失败";
    public static final String FILE_NULL = "文件为空";
    public static final String GS_ERROR = "文件格式错误";
    public static final String UPLOAD_FAIL = "上传图片失败";
    public static final String UPLOAD_SUCCESS = "上传图片成功";
    
    public static final String BC_REPEAT = "该用户记录已存在";
    public static final String lOGINNAME_REPEAT = "该登录名称已存在";

    public static final String ORDER_NUMBER = "序号已存在";

    /*
     * 分页信息
     */
    private static final String PAGE_SIZE = "pageSize";
    private static final String PAGE_NUM = "currentPage";

    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    // 可编辑状态
    public static final int EDIT_YES = 1;
    public static final int EDIT_NO = 0;


    private static final String SYSID = "10998";
    
    private static final String LOGMEMO = "操作完成";
    
    public static String getLogmemo() {
        return LOGMEMO;
    }
    
    public static String getSYSID() {
        return SYSID;
    }

    /*
     * 调用网关服务不传 key 值
     */
    public static final String POST_TO_GATEWAY_NO_KEY = "postToGatewayNoKey";
    
    /*
     * 父级字典
     */
    public static final String CYFZ_DICT = "cyfz_dict";
    
    public static String getCommonStr0() {
        return COMMON_STR_0;
    }

    public static String getCommonStr1() {
        return COMMON_STR_1;
    }

    public static String getCommonStr2() {
        return COMMON_STR_2;
    }

    public static String getCommonStr3() {
        return COMMON_STR_3;
    }

    public static String getCommonStr4() {
        return COMMON_STR_4;
    }

    public static String getCommonStr5() {
        return COMMON_STR_5;
    }

    public static String getPageSize() {
        return PAGE_SIZE;
    }

    public static String getPageNum() {
        return PAGE_NUM;
    }

    public static Integer getDefaultPageNum() {
        return DEFAULT_PAGE_NUM;
    }

    public static Integer getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }
}