package com.syj.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syj.springcloud.pojo.Payment;
import com.syj.springcloud.service.PaymentService;
import com.syj.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author song
* @description 针对表【payment】的数据库操作Service实现
* @createDate 2023-05-18 14:26:09
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService {
    @Resource(name = "paymentMapper")
    private PaymentMapper paymentMapper;

    @Override
    public Payment getPayment(Long id) {
        Payment payment = paymentMapper.selectById(id);
        return payment;
    }
}




