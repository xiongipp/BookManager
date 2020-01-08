package com.xxh.library.msg;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;


public class ErrorMsg extends R {
    String msg;
    long code;
    public void userExist(){
        msg="用户的id已经存在";
        code=100;
    }
}
