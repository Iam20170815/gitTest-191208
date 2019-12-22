package com.example.demo.controller;

import com.example.demo.comm.DemoConstants;
import com.example.demo.dto.PEKXXXXAX1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/15 21:22
 */
@RestController
public class LombokController {

    @Resource(name = "xPekXxxXaX1")
    private PEKXXXXAX1 pekxxxxax1;

    /**
     * 测试lombok注解
     *
     * @param stringPam
     * @return
     */
    @RequestMapping("/lombok")
    public String lombok(String stringPam) {

        //使用拦截器对参数进行检查
        if (null == stringPam) {
            return "Input String is null！";
        }

        pekxxxxax1.setXTrxEac(stringPam);
        if (DemoConstants.CARD_622609.equals(stringPam.substring(0,6))) {
            pekxxxxax1.setXCnlRut("BQXM00");
            pekxxxxax1.setXSpc080("YYY");
        }

        return pekxxxxax1.toString();
    }

}
