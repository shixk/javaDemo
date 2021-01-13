package com.xuekai.enums;

import com.google.common.collect.Maps;
import com.xuekai.entity.People;
import com.xuekai.entity.Student;
import com.xuekai.utils.SpringUtil;
import lombok.Getter;

import java.util.Map;

/**
 * @Author shixuekai
 * @CreateDate 2019/12/25
 * @Description
 **/
@Getter
public enum NameAndClassPairEnum {

    Student("Student",Student.class);

    private String className;

    private Class<? extends People> clazz;

    private static Map<String, NameAndClassPairEnum> map = Maps.newHashMap();

    NameAndClassPairEnum(String className,Class<? extends People> clazz){
        this.className=className;
        this.clazz=clazz;
    }

    static {
        for (NameAndClassPairEnum nameAndClassPairEnum : NameAndClassPairEnum.values()) {
            map.put(nameAndClassPairEnum.getClassName(), nameAndClassPairEnum);
        }
    }

    public static NameAndClassPairEnum getNameAndClass(String beanName){
        return map.get(beanName);
    }

    public People getActuator(String beanName){
        NameAndClassPairEnum pairEnum = getNameAndClass(beanName);

        return SpringUtil.getBean(pairEnum.getClazz());
    }
}
