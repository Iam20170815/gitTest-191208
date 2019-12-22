package com.example.demo.controller;

import com.example.demo.comm.CalculateUtil;
import com.example.demo.comm.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/test")
@Api(tags = "公共函数测试controller")
public class TestController {

    /**
     * 计算字符串的字符数
     *
     * @param chnlFlag
     * @param rspcode
     * @return
     */
    @GetMapping("/resultRsp/{chnlFlag}/{rspcode}")
    @ApiOperation("测试接口统一应答码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "chnlFlag", value = "通道类型", defaultValue = "ER"),
            @ApiImplicitParam(name = "rspcode", value = "原始应答码", defaultValue = "PER0003")
    })
    public String resultRsp(@PathVariable String chnlFlag,@PathVariable String rspcode) {

        return ResultResponse.mappingRspCd(chnlFlag, rspcode).getRespCode();
    }

    /**
     * 计算字符串的字符数
     *
     * @param stringPam
     * @return
     */
    @RequestMapping("/stringLen")
    @ApiIgnore
    public int calStringLen(String stringPam) {

        return CalculateUtil.calStrLen(stringPam);
    }

    /**
     * helloworld测试
     *
     * @return
     */
    @RequestMapping("/test")
    @ApiIgnore
    public String test() {

        return "Test Spring Boot!";
    }
}
