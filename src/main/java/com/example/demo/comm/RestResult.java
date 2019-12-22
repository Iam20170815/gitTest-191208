package com.example.demo.comm;

import lombok.Data;

/**
 * 统一RESTfulAPI响应结果封装
 *
 * @Author wudongli
 * @Date 2019/12/18 21:24
 */
@Data
public class RestResult {
    private int code;
    private String message;
    private Object data;

    public RestResult setCode(ResultCodeEnum resultCode) {
        this.code = resultCode.code;
        return this;
    }
}
