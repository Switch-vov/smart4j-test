package com.switchvov.smart4j.test.aspect;

import com.switchvov.smart4j.framework.annotation.Aspect;
import com.switchvov.smart4j.framework.annotation.Controller;
import com.switchvov.smart4j.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截Controller所有方法
 * Created by Switch on 2017/5/28.
 */
@Aspect(Controller.class)
public class ContollerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContollerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> clazz, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------- begin ----------");
        LOGGER.debug(String.format("class：%s", clazz.getName()));
        LOGGER.debug(String.format("method：%s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> clazz, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug(String.format("time：%dms", System.currentTimeMillis() - begin));
        LOGGER.debug("---------- end ----------");
    }
}
