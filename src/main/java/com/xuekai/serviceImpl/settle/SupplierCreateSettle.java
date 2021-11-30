package com.xuekai.serviceImpl.settle;

import com.xuekai.anotation.SettleExtension;
import com.xuekai.service.settle.ICreateSettle;
import org.springframework.stereotype.Service;

@SettleExtension(value = "supplier",beanDiscribe = "商家结算实现类")
@Service
public class SupplierCreateSettle implements ICreateSettle {
    @Override
    public void excute() {
        System.out.println("执行了商家结算逻辑");
    }
}
