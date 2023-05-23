package com.syj.springcloud.service.Impl;

import com.syj.springcloud.pojo.CommenResult;
import com.syj.springcloud.pojo.Payment;
import com.syj.springcloud.service.PaymentFeignService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignHystrixService implements PaymentFeignService {
    @Override
    public CommenResult<Payment> getPayment(Long id) {
        return null;
    }

    @Override
    public Object getDiscoveryClient() {
        return Thread.currentThread().getName()+"  服务器繁忙，请稍后重试/(ㄒoㄒ)/~~";
    }
}
