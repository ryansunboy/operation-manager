package com.hundsun.operation.manager.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Copyright: 恒生电子股份有限公司.All rights reserved.
 *
 * @description: open-platform-parent
 * @author: wangxf19546
 * @create: 2018-09-28 16:29
 * @version: 1.0
 **/
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     *     获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 通过name获取Bean.
     */
    public static <T> T getBean(String name) {
        return (T)applicationContext.getBean(name);
    }
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

}