package com.example.demo.service.impl;

import com.example.demo.comm.CalculateUtil;
import com.example.demo.service.HashService;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashServiceImpl implements HashService {

    @Override
    public Map listToMap(List list) {

        Map seqMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            seqMap.put(i, list.get(i));
        }

        return seqMap;
    }

    @Override
    public String sha256Summary(String messageStr) {
        //输入检查
        if (null == messageStr) {
            return "Input String is null！";
        }

        //摘要计算
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            //sha256计算
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(messageStr.getBytes("UTF-8"));
            byte[] shaResultByte = messageDigest.digest();
            //结果转化为16进制字符串
            encodestr = CalculateUtil.byte2Hex(shaResultByte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encodestr;
    }

    @Override
    public String sha1Summary(String messageStr) {
        //输入检查
        if (null == messageStr) {
            return "Input String is null！";
        }

        //摘要计算
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            //sha1计算
            messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(messageStr.getBytes("UTF-8"));
            byte[] shaResultByte = messageDigest.digest();

            //结果转化为16进制字符串
            encodestr = CalculateUtil.byte2Hex(shaResultByte);
//            StringBuffer hexValue = new StringBuffer();
//            for (int i = 0; i < shaResultByte.length; i++) {
//                int val = ((int) shaResultByte[i]) & 0xff;
//                if (val < 16) {
//                    hexValue.append("0");
//                }
//                hexValue.append(Integer.toHexString(val));
//            }
//
//            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encodestr;
    }
}
