package com.example.demo.domain;

import lombok.Data;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/18 21:36
 */
@Data
public class CardDO {

    private String cardNumber;//卡号
    private String debitFlag; //借贷记标志
    private String insCode;   //发卡机构
}
