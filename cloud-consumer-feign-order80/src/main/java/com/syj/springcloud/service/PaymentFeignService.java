package com.syj.springcloud.service;

import com.syj.springcloud.pojo.CommenResult;
import com.syj.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("cloud-provider-payment")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommenResult<Payment> getPayment(@PathVariable("id") Long id);
    @GetMapping("/payment/discoveryClient")
    Object getDiscoveryClient();
}
