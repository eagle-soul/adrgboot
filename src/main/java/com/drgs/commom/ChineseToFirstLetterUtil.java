package com.drgs.commom;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Random;

/**
 * 提取汉字首字母工具类
 */
public class ChineseToFirstLetterUtil {

    public static String ChineseToFirstLetter(String c) {
        String string = "";
        char b;
        int a = c.length();
        for (int k = 0; k < a; k++) {
            b = c.charAt(k);
            String d = String.valueOf(b);
            String str = converterToFirstSpell(d);
            char h;
            int j = str.length();
            for (int y = 0; y <= 0; y++) {
                h = str.charAt(0);
                string += h;
            }
        }
        return string;
    }

    public static String converterToFirstSpell(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            String s = String.valueOf(nameChar[i]);
            if (s.matches("[\\u4e00-\\u9fa5]")) {
                try {
                    String[] mPinyinArray = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
                    pinyinName += mPinyinArray[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    public static String getPassword() {
        String password = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            int charOrNum = random.nextInt(2);
            if (charOrNum == 1) {
                password += (char) (random.nextInt(26) + 97);
            }else {
                password += random.nextInt(10);
            }
        }
        return password;
    }

    public static String getLoginNum(String unitName) {
        String loginNum = unitName;
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            int charOrNum = random.nextInt(2);
            if (charOrNum == 1) {
                loginNum += (char) (random.nextInt(26) + 97);
            }else {
                loginNum += random.nextInt(10);
            }
        }
        return loginNum;
    }


//    public static void main(String[] args) {
//        System.err.println(ChineseToFirstLetter("犯我中华者虽远必诛"));
//        char char1 = 30000;
//        char char2 = '2';
//        char charstr = "犯我中华者虽远必诛".charAt(0);
//        boolean boo = "2".matches("[\0-9]");
//        int char3 = char1 + char2;
////        System.out.println(("犯我中华者虽远必诛".charAt(0)+" "+"犯我中华者虽远必诛".charAt(1)+
////                "犯我中华者虽远必诛".charAt(2)+"犯我中华者虽远必诛".charAt(3)).replace(" ",""));
//        System.out.println("犯我中华者虽远必诛".charAt(0));
//        System.out.println("犯我中华者虽远必诛".charAt(1) + "犯我中华者虽远必诛".charAt(2));
//        int charint = ("犯我中华者虽远必诛".charAt(1) + "犯我中华者虽远必诛".charAt(2));
//        System.out.println(charint);
//        System.out.println("犯我中华者虽远必诛".charAt(2));
//        System.out.println("犯我中华者虽远必诛".charAt(3));
//        System.out.println("犯我中华者虽远必诛".charAt(4));
//    }


}