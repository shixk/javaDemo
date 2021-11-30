package com.xuekai.serviceImpl.settle;

import com.xuekai.anotation.SettleExtension;
import com.xuekai.service.settle.ICreateSettle;
import org.springframework.stereotype.Service;

@SettleExtension(value = "groupHeader",beanDiscribe = "团长结算实现")
@Service
public class GroupheaderCreateSettle implements ICreateSettle {
    @Override
    public void excute() {
        System.out.println("执行了团长结算的逻辑");
    }
}
