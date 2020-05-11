package com.drgs.commom;

public class AgeTool {
    public static int StrToInt(String str){

        switch (str.length()){
            case 1 :
                String index1 = str.substring(0,1);
                return CNToInt(index1);
            case 2 :
                index1 = str.substring(0,1);
                String index2 = str.substring(1,2);
                if (numFlag(index2)){
                    return CNToInt(index1)*10+CNToInt(index2);
                }else {
                    return CNToInt(index1);
                }
            case 3 :
            case 4 :
            case 5 :
                index1 = str.substring(0,1);
                index2 = str.substring(1,2);
                return CNToInt(index1)*10+CNToInt(index2);
            default:
                    return 0;
        }
    }
    private static boolean numFlag(String str){
        if (str.toCharArray()[0]>='0'&& str.toCharArray()[0]<='9'){
            return true;
        }else {
            return false;
        }
    }

    private static int CNToInt(String str){
        if (str.toCharArray()[0]>='0'&& str.toCharArray()[0]<='9'){
            return Integer.parseInt(str);
        }else {
            return 0;
        }
    }
}
