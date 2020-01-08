package com.xxh.library.msg;

import lombok.Data;

@Data
public class LoginMsg {
    int state;
    String msg;
    public void noUser(){
        state=100;
        msg="用户不存在";
    }
    public void pswWrong(){
        state=100;
        msg="用户密码错误";
    }
    public  void  succ(){
        state=200;
        msg="登录成功";
    }

}
