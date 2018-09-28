package com.kenhome.server.service.coinApi.impl;

import com.kenhome.common.constant.coinApi.CoinApiEnum;
import com.kenhome.common.model.universal.ResponseModel;
import com.kenhome.server.service.coinApi.CoinApiService;
import org.springframework.stereotype.Service;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:22 2018/9/21 0021
 * @Modified By:
 */
@Service
public class EthApiServiceImpl implements CoinApiService {

    @Override
    public CoinApiEnum getCode() {
        return CoinApiEnum.ETHAPI;
    }

    @Override
    public ResponseModel test() {
        return ResponseModel.success("ETH");
    }
}
