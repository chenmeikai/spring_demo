package com.kenhome.service.service.coinApi;

import com.kenhome.common.constant.coinApi.CoinApiEnum;
import com.kenhome.common.model.universal.ResponseModel;

/**
 * @Author cmk
 * @Description 货币处理接口基类
 * @Date 2018\9\20 0020 22:53
 */
public interface CoinApiService {


    public CoinApiEnum getCode();

    public ResponseModel test();
}
