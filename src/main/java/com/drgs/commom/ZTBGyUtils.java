package com.drgs.commom;



import com.github.pagehelper.PageHelper;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @project cloudplatform
 * @package com.css.ztb.cxpt.utils
 * @file ZTBGyUtils.java 创建时间:2019年4月17日下午3:54:40
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @author 史雪涛
 * @reviewer 审核人
 * @version 1.0
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 *
 */
@Component
public class ZTBGyUtils {

    /**
     * 判空方法
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:06:10
     * @param obj
     *            对象
     * @return true、false
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNull(Object obj) {
        boolean isNullFlag = true;
        if (obj != null) {
            if (obj instanceof List<?>) {
                isNullFlag = isNull((List<?>) obj);
            } else if (obj instanceof Set<?>) {
                isNullFlag = isNull((Set<?>) obj);
            } else if (obj instanceof Object[]) {
                isNullFlag = isNull((Object[]) obj);
            } else if (obj instanceof Map) {
                isNullFlag = isNull((Map) obj);
            } else if (obj instanceof String) {
                isNullFlag = isNull((String) obj);
            } else if (obj instanceof Integer) {
                isNullFlag = isNull((Integer) obj);
            } else {
                isNullFlag = false;
            }
        }
        return isNullFlag;
    }

    /**
     * 判断列表是否为空
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:06:44
     * @param list
     *            disease
     * @return true、false;
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean isNull(List<?> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }

    /**
     * 判断列表是否为空
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:06:44
     * @param set
     *            set集合
     * @return true、false;
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean isNull(Set<?> set) {
        return set == null || set.size() == 0;
    }

    /**
     * @name 判断数组是否为空
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:06:44
     * @param objects
     *            数组
     * @return true、false;
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean isNull(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 
     * @name 判断Map是否为空
     * @description 判断Map是否为空
     * @time 创建时间:2014-7-5上午10:16:53
     * @param map
     *            map集合
     * @return boolean值
     * @author 康聪
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean isNull(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断字符串是否为空
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:08:09
     * @param str
     *            字符串
     * @return true、false
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static boolean isNull(String str) {
        return str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str.trim()) || "undefined".equalsIgnoreCase(str.trim());
    }

    /**
     * 判断整数是否为空
     * @param integer
     * @return
     */
    public static boolean isNull(Integer integer) {
        return integer == null;
    }

    /**
     * 
     * @name 中文名称
     * @description string转换为map
     * @time 创建时间:2017年2月14日下午1:08:34
     * @param kzzdjzd
     *            字符串
     * @return map map
     * @throws Exception
     *             异常
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Map<String, Object> conversStrToMap(String kzzdjzd) throws Exception {
        final Map<String, Object> map = new HashMap<String, Object>();
        if (ZTBGyUtils.isNull(kzzdjzd)) {
            return map;
        }
        final String[] jzdArr = kzzdjzd.split(",");
        for (int i = 0; i < jzdArr.length; i++) {
            final String jzd = jzdArr[i];
            final String[] kzzdArr = jzd.split("=");
            if (kzzdArr.length > 1) {
                map.put(kzzdArr[0], kzzdArr[1]);
            } else {
                map.put(kzzdArr[0], "");
            }
        }
        return map;
    }

    /**
     * 
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2017年2月14日下午1:08:34
     * @param str
     *            字符串
     * @return 字符串
     * @author 作者 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String conversStrToVoStytle(String str) {
        String tmp = str.toLowerCase();
        int ind = tmp.indexOf("_");
        while (ind >= 0) {
            tmp = tmp.substring(0, ind) + tmp.substring(ind + 1, ind + 2).toUpperCase() + tmp.substring(ind + 2);
            ind = tmp.indexOf("_");
        }
        return tmp;
    }

    /**
     * @name 驼峰转大写下划线
     * @description 连续数字仅第一位视作大写
     * @time 创建时间:2017-3-18下午07:45:28
     * @param str
     *            驼峰字符串
     * @return str 大写下划线字符串
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String convertVOStrToUnderlineStyle(String str) {
        if (str == null || "".equals(str.trim())) {
            return "";
        }
        final int len = str.length();
        final StringBuilder buffer = new StringBuilder();
        buffer.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < len; i++) {
            final char c = str.charAt(i);
            final char cBefore = str.charAt(i - 1);
            if (Character.isUpperCase(c) || (Character.isDigit(c) && Character.isLetter(cBefore))) {
                buffer.append('_');
                buffer.append(c);
            } else {
                buffer.append(Character.toUpperCase(c));
            }
        }
        return buffer.toString();
    }

    /**
     * 
     * @name 缓存Map，全是大写字段改为驼峰式字段
     * @description map转换为string，格式为 键=值,
     * @time 创建时间:2017年2月14日下午1:08:34
     * @param map
     *            参数
     * @return String 字符串
     * @throws Exception
     *             异常
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Map<String, Object> getCusMapByCatchMap(Map<String, Object> map) throws Exception {
        final Map<String, Object> resMap = new HashMap<String, Object>();
        if (!ZTBGyUtils.isNull(map)) {
            final Iterator<String> keyIt = map.keySet().iterator();
            while (keyIt.hasNext()) {
                String key = keyIt.next();
                final Object value = (Object) map.get(key);
                key = ZTBGyUtils.conversStrToVoStytle(key);
                resMap.put(key, value);
            }
        }
        return resMap;
    }

    /**
     * 
     * @name 全是大写字段改为驼峰式字段
     * @description map转换为string，格式为 键=值,
     * @time 创建时间:2017年2月14日下午1:08:34
     * @param list
     *            参数
     * @return String 字符串
     * @throws Exception
     *             异常
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static List<Map<String, Object>> getCusListByCacheList(List<Map<String, Object>> list) throws Exception {
        final List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        if (!ZTBGyUtils.isNull(list)) {
            for (Map<String, Object> map : list) {
                final Map<String, Object> resMap = new HashMap<String, Object>();
                if (!ZTBGyUtils.isNull(map)) {
                    final Iterator<String> keyIt = map.keySet().iterator();
                    while (keyIt.hasNext()) {
                        String key = keyIt.next();
                        final Object value = (Object) map.get(key);
                        key = ZTBGyUtils.conversStrToVoStytle(key);
                        resMap.put(key, value);
                    }
                }
                resList.add(resMap);
            }
        }
        return resList;
    }

    /**
     * 
     * @name 全是驼峰式字段改为大写字段
     * @description map转换为string，格式为 键=值,
     * @time 创建时间:2017年2月14日下午1:08:34
     * @param map
     *            参数
     * @return String 字符串
     * @throws Exception
     *             异常
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Map<String, Object> getCacheKeyMapByCusMap(Map<String, Object> map) throws Exception {
        final Map<String, Object> resMap = new HashMap<String, Object>();
        if (!ZTBGyUtils.isNull(map)) {
            final Iterator<String> keyIt = map.keySet().iterator();
            while (keyIt.hasNext()) {
                String key = keyIt.next();
                final Object value = map.get(key);
                key = ZTBGyUtils.convertVOStrToUnderlineStyle(key);
                if (!ZTBGyUtils.isNull(value)) {
                    resMap.put(key, value.toString());
                } else {
                    resMap.put(key, "");
                }
            }
        }
        return resMap;
    }


//    /**
//     *@name    计算起始和截止日期，结束日期自动加一天
//     *@description 相关说明
//     *@time    创建时间:2019年8月8日下午2:14:44
//     *@param date 时间
//     *@param flag 起始日期或者截止日期标志，true 起始日期，false-结束日期
//     *@return 计算好的日期
//     *@throws Exception
//     *@author   作者：张朋博
//     *@history 修订历史（历次修订内容、修订人、修订时间等）
//     */
//    public static String fomartStartAndEndRQ(String date, boolean flag) throws Exception {
//        if (ZTBGyUtils.isNull(date)) {
//            return "";
//        }
//        final String reTime = ZTBGyUtils.formatDateForRQ(date);
//        final Date rDate;
//        //        reTime = reTime + " 00:00:00";
//        // 自动加一天
//        final Calendar cld = ZTBDateUtils.parseDate(reTime);
//        if (!flag) {
//            cld.add(Calendar.DAY_OF_MONTH, 1);
//        }
//        rDate = ZTBDateUtils.convertCalendarToDate(cld);
//        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        return sdf.format(rDate);
//    }

    /**
     * 从list中得到根据某个key去重的结果集
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2018年7月5日下午2:50:41
     * @param list
     *            传入参数
     * @param key
     *            key
     * @return 返回结果集
     * @throws Exception
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String getDistinctValueStringFromListByKey(List<Map<String, Object>> list, String key) throws Exception {
        String res = "";
        final Map<Object, Object> paramMap = new HashMap<Object, Object>();
        for (Map<String, Object> map : list) {
            final Object value = (Object) map.get(key);
            if (!ZTBGyUtils.isNull(value)) {
                if (paramMap.containsKey(value)) {
                    continue;
                } else {
                    res += String.valueOf(value) + ",";
                    paramMap.put(value, value);
                }
            }
        }
        if (!ZTBGyUtils.isNull(res)) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    /**
     * 从list中得到根据某个key去重的结果集
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2018年7月5日下午2:50:41
     * @param list
     *            传入参数
     * @param key
     *            key
     * @return 返回结果集
     * @throws Exception
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static List<Map<String, Object>> getDistinctListFromListByKey(List<Map<String, Object>> list, String key) throws Exception {
        final Map<Object, Object> paramMap = new HashMap<Object, Object>();
        final List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : list) {
            final Object value = (Object) map.get(key);
            if (!ZTBGyUtils.isNull(value)) {
                if (paramMap.containsKey(value)) {
                    continue;
                } else {
                    paramMap.put(value, value);
                    resList.add(map);
                }
            }
        }
        return resList;
    }

    /**
     * 从list中得到根据某个key去重的结果集
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2018年7月5日下午2:50:41
     * @param list
     *            传入参数
     * @param key
     *            key
     * @return 返回结果集
     * @throws Exception
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static List<String> getDistinctValueListFromListByKey(List<Map<String, Object>> list, String key) throws Exception {
        final String values = getDistinctValueStringFromListByKey(list, key);
        final List<String> resList = new ArrayList<String>();
        if (!ZTBGyUtils.isNull(values)) {
            Collections.addAll(resList, values.split(","));
        }
        return resList;
    }


    /**
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2018年12月28日下午3:01:08
     * @return uuid
     * @throws Exception
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String generateRandomString() throws Exception {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * 排序
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2018年12月29日上午10:52:31
     * @param o1
     *            map
     * @param o2
     *            map
     * @return 排序号
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    private static int getOrder(Map<String, Object> o1, Map<String, Object> o2) {
        Integer xsxh1 = 1;
        Integer xsxh2 = 1;
        String ordernum1 = (String) o1.get("ordernum");
        if (ZTBGyUtils.isNull(ordernum1)) {
            ordernum1 = (String) o1.get("sxh");
        }
        if (!ZTBGyUtils.isNull(ordernum1)) {
            xsxh1 = Integer.parseInt(ordernum1);
        }
        String ordernum2 = (String) o2.get("ordernum");
        if (ZTBGyUtils.isNull(ordernum2)) {
            ordernum2 = (String) o2.get("sxh");
        }
        if (!ZTBGyUtils.isNull(ordernum2)) {
            xsxh2 = Integer.parseInt(ordernum2);
        }
        return xsxh1.compareTo(xsxh2);
    }

    /**
     * disease 根据其中的某个字段进行分组
     *
     * @name 中文名称
     * @description 相关说明
     * @time 创建时间:2019年1月9日下午10:03:03
     * @param list
     *            disease
     * @param key
     *            key
     * @return MAP
     * @author 史雪涛
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static Map<String, List<Map<String, Object>>> getMapByListAndMapKey(List<Map<String, Object>> list, String key) throws Exception {
        final Map<String, List<Map<String, Object>>> resMap = new HashMap<String, List<Map<String, Object>>>();
        if (!ZTBGyUtils.isNull(list)) {
            for (Map<String, Object> map : list) {
                final String value = (String) map.get(key);
                if (ZTBGyUtils.isNull(resMap.get(value))) {
                    final List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
                    resList.add(map);
                    resMap.put(value, resList);
                } else {
                    final List<Map<String, Object>> resList = resMap.get(value);
                    resList.add(map);
                    resMap.put(value, resList);
                }
            }
        }
        return resMap;
    }

    /**
     * @param map
     * @return
     * @throws Exception
     * @author 张朋博
     */
    public static Map<String, Object> getStringMapByCatchMap(Map<String, Object> map) throws Exception {
        final Map<String, Object> resMap = new HashMap<String, Object>();
        if (!ZTBGyUtils.isNull(map)) {
            final Iterator<String> keyIt = map.keySet().iterator();
            while (keyIt.hasNext()) {
                final String key = keyIt.next();
                final Object value = (Object) map.get(key);
                if (!ZTBGyUtils.isNull(value)) {
                    resMap.put(key, value.toString());
                }
            }
        }
        return resMap;
    }

    /**
     * @param list
     * @return
     * @throws Exception
     * @author 张朋博
     */
    public static List<Map<String, Object>> getStringListByCatchList(List<Map<String, Object>> list) throws Exception {
        final List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        if (!ZTBGyUtils.isNull(list)) {
            for (Map<String, Object> map : list) {
                final Map<String, Object> resMap = new HashMap<String, Object>();
                if (!ZTBGyUtils.isNull(map)) {
                    final Iterator<String> keyIt = map.keySet().iterator();
                    while (keyIt.hasNext()) {
                        final String key = keyIt.next();
                        final Object value = (Object) map.get(key);
                        if (!ZTBGyUtils.isNull(value)) {
                            resMap.put(key, value.toString());
                        }
                    }
                }
                resList.add(resMap);
            }
        }
        return resList;
    }


    /**
     *@name    设置分页信息
     *@description 相关说明
     *@time    创建时间:2019年09月19日 11:58
     *@param paramMap paramMap
     *@throws Exception e
     *@return void
     *@author   汪兴驰
     *@history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static void setPageInfo(Map<String, Object> paramMap){
        Object pageNum = paramMap.get(ZTBConstants.getPageNum());
        Object pageRows = paramMap.get(ZTBConstants.getPageSize());
        if (ZTBGyUtils.isNull(pageNum)) {
            pageNum = ZTBConstants.getDefaultPageNum();
        }
        if (ZTBGyUtils.isNull(pageRows)) {
            pageRows = ZTBConstants.getDefaultPageSize();
        }
        PageHelper.startPage((Integer) pageNum, (Integer) pageRows);
    }

}
