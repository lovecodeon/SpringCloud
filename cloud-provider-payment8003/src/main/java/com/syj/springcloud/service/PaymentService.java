package com.syj.springcloud.service;

import com.syj.springcloud.pojo.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author song
* @description 针对表【payment】的数据库操作Service
* @createDate 2023-05-18 14:26:09
*/
public interface PaymentService extends IService<Payment> {
    Payment getPayment(Long id);
}
