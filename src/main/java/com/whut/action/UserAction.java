package com.whut.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.whut.service.UserService;
import com.whut.domain.User;
import java.util.Map;


/**
 * Created by WH on 2017/6/21.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user=new User();
    @Override
    public User getModel() {
        return user;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private Map session;
    public String login(){

        if (userService.userLogin(user)){
            session= ActionContext.getContext().getSession();
            session.put("username",user.getUsername());

            return SUCCESS;
        }

        else {
            session= ActionContext.getContext().getSession();
            session.put("username","null");
            return LOGIN;
        }
   }
}
