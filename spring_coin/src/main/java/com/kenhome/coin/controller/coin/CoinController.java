package com.kenhome.web.controller.coin;

import com.kenhome.common.constant.coinApi.CoinApiEnum;
import com.kenhome.common.model.universal.ResponseModel;
import com.kenhome.service.service.coinApi.CoinApiService;
import com.kenhome.service.service.coinApi.impl.CoinApiFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:24 2018/9/21 0021
 * @Modified By:
 */

@RestController
@RequestMapping("coin")
public class CoinController {


    @Autowired
    private CoinApiFactory coinApiFactory;

    @GetMapping("test")
    public ResponseModel getTest(String coinName){

        CoinApiEnum coinApiEnum=CoinApiEnum.BTCAPI;

        if("ETH".equals(coinName)){
            coinApiEnum =CoinApiEnum.ETHAPI;
        }
        if("BTC".equals(coinName)){
            coinApiEnum =CoinApiEnum.BTCAPI;
        }
        if("ERC".equals(coinName)){
            coinApiEnum =CoinApiEnum.ERC20Api;
        }

        CoinApiService coinApi = coinApiFactory.getCoinApi(coinApiEnum);
        return  coinApi.test();
    }

}
