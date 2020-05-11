package com.drgs.commom;

public class InterceptStr {
    //截取其中非汉字部分
    public static String InterceptCharacter(String str){
        StringBuffer sb = new StringBuffer();
        for (char item : str.toCharArray())
            if (CharacterFlag(item)) {
                sb.append(item);
            }
        return sb.toString();
    }
    //截取汉字部分
    public static String InterceptCNCharacter(String str){
        StringBuffer sb = new StringBuffer();
        for (char item : str.toCharArray())
            if (CNCharacterFlag(item)) {
                sb.append(item);
            }
        return sb.toString();
    }

    private static boolean CharacterFlag(char charValue) {
        return !(charValue >= 0x4E00 && charValue <= 0X9FA5);
    }

    private static boolean CNCharacterFlag(char charValue) {
        return (charValue >= 0x4E00 && charValue <= 0X9FA5);
    }
}
