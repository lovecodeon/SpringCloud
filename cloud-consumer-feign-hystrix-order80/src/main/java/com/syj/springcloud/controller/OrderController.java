package com.syj.springcloud.controller;

import com.syj.springcloud.pojo.CommenResult;
import com.syj.springcloud.pojo.Payment;
import com.syj.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }
    @GetMapping("/consumer/payment/discoveryClient")
    public Object getDiscoveryClient(){
        return paymentFeignService.getDiscoveryClient();
    }
}
