package com.example.demo.controller;

import com.example.demo.comm.AjaxResponse;
import com.example.demo.domain.CardDO;
import com.example.demo.service.CardDOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful Controller测试
 *
 * @Author wudongli
 * @Date 2019/12/18 21:44
 */
@Slf4j
@RestController
@RequestMapping("/cardrest")
public class CardRestController {

    @Autowired
    private CardDOService cardDOService;
    /**
     * 添加一张卡
     * 注意：如果使用了lombok的@Builder,会导致JSON无法转对象
     * @param cardDO
     * @return
     */
    @PostMapping(value = "/card")
    public AjaxResponse addCard(@RequestBody CardDO cardDO) {
        log.info("saveCard:{}", cardDO);
        return AjaxResponse.success(cardDO);
    }

    /**
     * 删除一张卡
     *
     * @param cardNumber
     * @return
     */
    @DeleteMapping("/card/{cardNumber}")
    public AjaxResponse deleteCard(@PathVariable String cardNumber) {
        log.info("deleteCard:{}", cardNumber);
        return AjaxResponse.success(cardNumber);
    }

    /**
     * 更新一张卡
     * @param cardNumber
     * @param cardDO
     * @return
     */
    @PutMapping("/card/{cardNumber}")
    public AjaxResponse updateCard(@PathVariable String cardNumber, @RequestBody CardDO cardDO) {
        cardDO.setCardNumber(cardNumber);

        log.info("updateCard:{}", cardDO);
        return AjaxResponse.success(cardDO);
    }

    /**
     * 查询一张卡
     * @param cardNumber
     * @return
     */
    @GetMapping("/card/{cardNumber}")
    public AjaxResponse queryCard(@PathVariable String cardNumber) {

       // CardDO cardDO = CardDO.builder().cardNumber("6226095710740002").debitFlag("D").insCode("03080000").build();
//        CardDO cardDO = new CardDO();
//        cardDO.setCardNumber(cardNumber);
//        cardDO.setDebitFlag("D");
//        cardDO.setInsCode("03080000");

        CardDO cardDO = cardDOService.Sel(cardNumber);
        return AjaxResponse.success(cardDO);
    }
}
