package com.drgs.login.controller;

import com.drgs.commom.ZTBConstants;
import com.drgs.commom.ZTBGyUtils;
import com.drgs.login.service.LoginService;
import com.drgs.vo.JsonResult;
import com.drgs.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestBody Map<String, Object> params) throws Exception {
        final JsonResult<Integer> jsonResult = new JsonResult<Integer>();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(ZTBConstants.CX_SUCCESS);
            jsonResult.setInfo(loginService.login(params));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(ZTBConstants.CX_FAIL);
        }
        return jsonResult;
    }

}

class Formal {
    private void formal(boolean p){
        p=false;
        System.out.println(p);
    }

    public static void main(String[]args){
        boolean i=true;
        Formal fromal=new Formal();
        fromal.formal(i);
        System.out.println(i);
    }
}

class Soundex {

    private static final long serialVersion = 1L;

    /*实现26个英文字母的映射*/
    public static final char[] MAP = {
            //A  B   C   D   E   F   G   H   I   J   K   L   M
            '0','1','2','3','0','1','2','0','0','2','2','4','5',
            //N  O   P   Q   R   S   T   U   V   W   X   Y   Z
            '5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    public static void main(String args[]) {

        List<String> names = new ArrayList<>();
        names.add("ccfefaacebe");
        names.add("sonzhaoheng");
        names.add("sungzhaoheng");
        names.add("sunzhaoheng");

        for(String name: names) {
            System.out.println(Soundex.soundex(name) + "---->" + name);
//            System.out.println(ToPinyin("汉字"));
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//            defaultFormat.

        }
    }

    /*将传过来的字符串转换为 Soundex 码
     *不能转换的返回null
     * */
     static String soundex(String s) {

        String t = s.toUpperCase();//将其转换为大写(实现英文字母的统一)

        StringBuffer sbu = new StringBuffer(); //StringBuffer更加安全
        char c;
        char prev = '?', PrevOutput = '?';//符号字符

        /*主循环，找出映射的字符（最多4个）
         * 算法仅能处理 ASCII 码，不要用Character.isLetter()
         * */
        for(int i = 0; i < t.length() && sbu.length() < 4 && (c = t.charAt(i)) != ','; i++) {

            //判断字母是否为大写，且是否为符号字符
            if(c >= 'A' && c <= 'Z' && c!= prev) {

                prev = c;

                //沿用首字符，依次进行排序，不是首字符的按照 Soundex 码
                if(i == 0) {
                    sbu.append(c);
                }else {
                    char m = MAP[c - 'A'];

					/*
					if(false) {
						System.out.println(c + "---->" + m);
					}*/

                    //去除重复的英文字母
                    if(m != '0' && m != PrevOutput) {
                        sbu.append(m);
                        PrevOutput = m;
                    }
                }
            }
        }

        //不能转换的返回null
        if(sbu.length() == 0) {
            return null;
        }

        //如果长度不够4就添加0
        for(int i = sbu.length(); i < 4; i++) {
            sbu.append('0');
        }

        return sbu.toString();
    }

}