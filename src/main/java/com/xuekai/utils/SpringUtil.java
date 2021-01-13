package com.xuekai.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * create by lijiajia on 2018/3/29
 */
public class SpringUtil implements ApplicationContextAware {
    private ApplicationContext appContext;

    public SpringUtil() {
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return ContextHolder.instance.appContext.getBean(name, requiredType);
    }

    public void setApplicationContext(ApplicationContext appContext) {
        ContextHolder.instance.appContext = appContext;
    }

    private static class ContextHolder {
        private static final SpringUtil instance = new SpringUtil();
    }

    public static <T> T getBean(Class<T> requiredType) {
        String beanName = "";
        String className = requiredType.getSimpleName();
        if (!StringUtils.isEmpty(className)) {
            beanName = new StringBuffer(className.length()).append(Character.toLowerCase(className.charAt(0)))
                    .append(className.substring(1)).toString();
        }
        return getBean(beanName, requiredType);
    }
}
