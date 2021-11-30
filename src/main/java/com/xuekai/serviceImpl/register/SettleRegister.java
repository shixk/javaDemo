package com.xuekai.serviceImpl.register;

import com.xuekai.anotation.SettleExtension;
import com.xuekai.service.settle.ICreateSettle;
import com.xuekai.serviceImpl.settle.DefaultCreateSettle;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class SettleRegister implements ApplicationContextAware {

    private static Map<String, ICreateSettle> map = new HashMap<>();

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        loadServiceImpl();
    }

    private void loadServiceImpl() {
        Map<String, Object> beansWithAnnotationMap = this.applicationContext.getBeansWithAnnotation(SettleExtension.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotationMap.entrySet()) {
            //获取声明该注解的bean实例
            ICreateSettle createSettleService = (ICreateSettle) entry.getValue();
            //获取该bean上的注解对象
            String type = entry.getValue().getClass().getAnnotation(SettleExtension.class).value();
            map.put(type, createSettleService);
        }
    }


    //根据业务类型，选择具体的实现类
    public ICreateSettle getCreateSettleService(String type){
        ICreateSettle bean = map.get(type);
        if(bean == null){
            return map.get("default");
        }else {
            return bean;
        }
    }
}
