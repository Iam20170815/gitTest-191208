package com.example.demo.comm;

/**
 * 工具处理类
 *
 * @Author wudongli
 * @Date 2019/12/15 9:09
 */
public class CalculateUtil {

    /**
     * 计算字符串的字符数
     * @param stringPam
     * @return
     */
    public static int calStrLen(String stringPam) {

        return stringPam.length();
    }

    /**
     * 将byte转为16进制字符串
     * @param bytes
     * @return
     */
    public static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
