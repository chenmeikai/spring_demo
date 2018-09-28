package com.kenhome.service.service.coinApi.impl;

import com.kenhome.common.constant.coinApi.CoinApiEnum;
import com.kenhome.service.service.coinApi.CoinApiService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:13 2018/9/21 0021
 * @Modified By:
 */

@Component
public class CoinApiFactory implements ApplicationContextAware {


    private static Map<CoinApiEnum, CoinApiService> coinApiMap;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, CoinApiService> map = applicationContext.getBeansOfType(CoinApiService.class);
        coinApiMap = new HashMap<>();
        map.forEach((key, value) -> coinApiMap.put(value.getCode(), value));

    }

    public  <T extends CoinApiService> T getCoinApi(CoinApiEnum coinApiEnum) {
        return (T)coinApiMap.get(coinApiEnum);
    }


}
