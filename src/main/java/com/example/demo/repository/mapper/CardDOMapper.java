package com.example.demo.repository.mapper;

import com.example.demo.domain.CardDO;
import org.springframework.stereotype.Repository;

/**
 * 类功能描述
 *
 * @Author wudongli
 * @Date 2019/12/21 23:49
 */
@Repository
public interface CardDOMapper {
    CardDO Sel(String cardNumber);
}
