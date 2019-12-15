package com.example.demo.controller;

import com.example.demo.service.HashService;
import com.example.demo.service.impl.HashServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/15 7:55
 */
public class HashController {

    @RequestMapping("/testHashMap")
    public String testHashMap() {

        //定义一个list
        List list = new ArrayList();
        list.add(0,"A1");
        list.add(1,"A2");
        list.add(2,"A3");
        list.add(3,"B1");
        list.add(4,"B2");

        //list转换为序号map
        HashService hashService = new HashServiceImpl();
        Map seqMap = hashService.listToMap(list);

        //输出
        return seqMap.toString();
    }
}
