package com.xuekai.serviceImpl.settle;

import com.xuekai.anotation.SettleExtension;
import com.xuekai.service.settle.ICreateSettle;
import org.springframework.stereotype.Service;

@SettleExtension(value = "agent",beanDiscribe = "代理商结算实现类")
@Service
public class AgentCreateSettle implements ICreateSettle {
    @Override
    public void excute() {
        System.out.println("执行了代理商结算实现");
    }
}
