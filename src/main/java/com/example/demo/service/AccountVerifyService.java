package com.example.demo.service;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/21 12:01
 */
public interface AccountVerifyService {
    /**
     * parm
     * 1.pHdl 操作数据库
     * 2.X1,X2,...Z1,Z2,...
     */
    void execute(String pHdl, Object...inputDDZ);
}
