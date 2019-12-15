package com.example.demo.controller;

import com.example.demo.comm.CalculateUtil;
import com.example.demo.service.HashService;
import com.example.demo.service.impl.HashServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    /**
     * 计算字符串的字符数
     *
     * @param stringPam
     * @return
     */
    @RequestMapping("/stringLen")
    public int calStringLen(String stringPam) {

        return CalculateUtil.calStrLen(stringPam);
    }

    /**
     * *********************************************************
     * helloworld测试
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {

        return "Test Spring Boot!";
    }
}
