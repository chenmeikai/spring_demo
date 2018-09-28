package com.kenhome.service.service.coinApi.impl;

import com.kenhome.common.constant.coinApi.CoinApiEnum;
import com.kenhome.common.model.universal.ResponseModel;
import com.kenhome.service.service.coinApi.CoinApiService;
import org.springframework.stereotype.Service;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:21 2018/9/21 0021
 * @Modified By:
 */
@Service
public class BtcApiServiceImpl implements CoinApiService {

    @Override
    public CoinApiEnum getCode() {
        return CoinApiEnum.BTCAPI;
    }

    @Override
    public ResponseModel test() {
        return ResponseModel.success("BTC");
    }
}
