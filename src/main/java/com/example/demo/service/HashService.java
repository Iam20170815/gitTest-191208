package com.example.demo.service;

import java.util.List;
import java.util.Map;

/**
 * @author shifuwang
 * @date 2019-12-14
 */
public interface HashService {

    /**
     * 列表转化为序号Map
     *
     * @param list
     * @return
     */
    Map listToMap(List list);

    /**
     * sha256摘要计算
     *
     * @param messageStr
     * @return 64位的16进制字符串
     */
    String sha256Summary(String messageStr);


    /**
     * sha1摘要计算
     *
     * @param messageStr
     * @return
     */
    String sha1Summary(String messageStr);
}
