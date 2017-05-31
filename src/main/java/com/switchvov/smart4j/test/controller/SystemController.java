package com.switchvov.smart4j.test.controller;

import com.switchvov.smart4j.framework.annotation.Action;
import com.switchvov.smart4j.framework.annotation.Controller;
import com.switchvov.smart4j.framework.bean.Param;
import com.switchvov.smart4j.framework.bean.View;
import com.switchvov.smart4j.plugin.security.SecurityHelper;
import com.switchvov.smart4j.plugin.security.exception.AuthcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 处理系统请求
 * Created by Switch on 2017/5/31.
 */
@Controller
public class SystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);


    /**
     * 进入首页界面
     */
    @Action("get:/")
    public View index() {
        return new View("index.jsp");
    }

    /**
     * 进入登录界面
     */
    @Action("get:/login")
    public View login() {
        return new View("login.jsp");
    }

    /**
     * 提交登录表单
     */
    @Action("post:/login")
    public View loginSubmit(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");
        try {
            SecurityHelper.login(username, password);
        } catch (AuthcException e) {
            LOGGER.error("login failure", e);
            return new View("/login");
        }
        return new View("/customer");
    }

    /**
     * 提交注销请求
     */
    @Action("get:/logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("/");
    }
}
