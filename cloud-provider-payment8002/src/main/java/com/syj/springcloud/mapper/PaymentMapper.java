package com.syj.springcloud.mapper;

import com.syj.springcloud.pojo.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author song
* @description 针对表【payment】的数据库操作Mapper
* @createDate 2023-05-18 14:26:09
* @Entity com.syj.springcloud.pojo.Payment
*/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}




