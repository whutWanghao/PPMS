package com.whut.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WH on 2017/6/27.
 * 测试一下请求百度地图Web服务API
 *
 */
public class LocationUtil {
    private static final String KEY="Ixat1U8qirT3MYWhsfehASlQY4QLzFc2";

    //返回输入地址的经纬度坐标值
    public static Map<String,String> getLatitude(String address){
        try {
            //输入的地址是汉字，必须对参数值编码处理，防止提交到后台成乱码
            address= URLEncoder.encode(address,"utf-8");
            //向后台请求geocoder服务，返回json格式
            URL resjson=new URL("http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&key="+KEY);
            //获得由该连接读入的InputStream
            BufferedReader in=new BufferedReader(new InputStreamReader(resjson.openStream()));
            String res=null;
            StringBuilder sb=new StringBuilder("");
            while ((res=in.readLine())!=null){
                //返回字符串的副本，忽略前后的空白
                sb.append(res.trim());
            }
            in.close();
            String str=sb.toString();
            System.out.println("return json"+str);
            if (str!=null&&!str.equals("")){
                Map<String,String> map=null;
                // \" 转义字符 表示"
                int lngStart=str.indexOf("lng\":");
                int lngEnd=str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if (lngStart>0&&lngEnd>0&&latEnd>0){
                    String lng=str.substring(lngStart+5,lngEnd);
                    String lat=str.substring(lngEnd+7,latEnd);
                    map=new HashMap<String,String>();
                    map.put("lng",lng);
                    map.put("lat",lat);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        Map<String,String> map=getLatitude("北京市海淀区上地十街10号");
        if (null!=map){
            System.out.println(map.get("lng"));
            System.out.println(map.get("lat"));
        }

    }
}
