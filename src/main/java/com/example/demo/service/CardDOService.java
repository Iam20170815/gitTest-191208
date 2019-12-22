package com.example.demo.service;

import com.example.demo.domain.CardDO;
import com.example.demo.repository.mapper.CardDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/21 23:46
 */
@Service
public class CardDOService {

    @Autowired
    CardDOMapper cardDOMapper;

    public CardDO Sel(String cardNumber) {
        return cardDOMapper.Sel(cardNumber);
    }
}
