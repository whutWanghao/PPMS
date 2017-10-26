package com.whut.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by WH on 2017/6/22.
 * 权限检查拦截器
 */
public class AuthorityInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //取得请求相关的ActionContext实例
        ActionContext context=actionInvocation.getInvocationContext();
        Map session=context.getSession();

        String username=(String) session.get("username");
        if (username!=null&&username.equals("admin")){
            System.out.println(username);
            return actionInvocation.invoke();
        }else {
            context.put("tip","您还没有登陆，请输入用户名和密码登陆系统");
            return Action.LOGIN;
        }

    }
}
