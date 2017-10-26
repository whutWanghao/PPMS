package com.whut.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CiperUtil {
    private final static String[] strDigits={"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    //将字节转换为16进制字符串
    private static String byteToArrayString(byte b){
        int i=b;
        if (i<0) i+=256;
        int iD1=i/16;
        int iD2=i%16;
        return strDigits[iD1]+strDigits[iD2];
    }

    //转换字节数组为16进制字符串
    private static String byteToString(byte[] bytes){
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<bytes.length;i++){
            sb.append(byteToArrayString(bytes[i]));
        }
        return sb.toString();
    }
    //对密码字符串MD5编码
    private static String encodeByMD5(String string){
        String resultString=null;
        try {
            resultString=new String(string);
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] bytes=md.digest(resultString.getBytes());
            resultString=byteToString(bytes);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return resultString.toUpperCase();
    }
    public static void main(String[] args) {
        System.out.println(encodeByMD5("123456"));
        System.out.println(encodeByMD5("wh19931017"));
    }
}
