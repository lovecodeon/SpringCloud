package com.syj.springcloud.controller;

import com.syj.springcloud.pojo.CommenResult;
import com.syj.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    public  static final String PAYMENT_URL="http://localhost:8001";
    public  static final String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommenResult.class);
    }
    @GetMapping("/consumer/payment/discoveryClient")
    public Object getDiscoveryClient(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discoveryClient",CommenResult.class);
    }
}
