package com.luobo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhangjiadong
 * @date 2020/6/11
 */
@Component
public class TaskAsyncHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(TaskAsyncHelper.applicationContext == null) {
            TaskAsyncHelper.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name){
        return TaskAsyncHelper.getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static  <T> void doTask(Class clazz,String name,T... params){
        Class[] classes = new Class[params.length] ;
        for (int i = 0; i <params.length ; i++) {
            classes[i] = params[i].getClass();
        }
        try {
            Method method = clazz.getDeclaredMethod(name,classes);
            method.invoke(getBean(clazz),params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
