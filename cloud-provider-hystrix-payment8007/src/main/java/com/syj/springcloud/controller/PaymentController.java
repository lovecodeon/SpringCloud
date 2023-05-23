package com.syj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.syj.springcloud.pojo.CommenResult;
import com.syj.springcloud.pojo.Payment;
import com.syj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/payment/get/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        return new CommenResult<>(200,"成功，serverPort:"+serverPort, payment);
    }
    @HystrixCommand(fallbackMethod ="getDiscoveryClient_preHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/payment/discoveryClient")
    public Object getDiscoveryClient(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("serviceId: "+instance.getServiceId()+" host: "+instance.getHost()+" port :"+instance.getPort()+" url "+instance.getUri());
            }
        }
        return new CommenResult<>(200,"成功，serverPort:"+serverPort, this.discoveryClient);
    }
    public String getDiscoveryClient_preHandler(){
        return Thread.currentThread().getName()+"  服务器繁忙，请稍后再试/(ㄒoㄒ)/~~";
    }
}
