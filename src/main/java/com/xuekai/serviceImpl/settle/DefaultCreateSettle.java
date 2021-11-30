package com.xuekai.serviceImpl.settle;


import com.xuekai.anotation.SettleExtension;
import com.xuekai.service.settle.ICreateSettle;
import org.springframework.stereotype.Service;

@SettleExtension(value = "default",beanDiscribe = "默认结算实现类")
@Service
public class DefaultCreateSettle implements ICreateSettle {
    @Override
    public void excute() {
        System.out.println("执行了默认实现类");
    }
}
