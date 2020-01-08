package com.xxh.library.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Admin)表实体类
 *
 * @author makejava
 * @since 2019-12-27 12:33:34
 */
@SuppressWarnings("serial")
public class Admin extends Model<Admin> {
    
    private Integer id;
    
    private String adname;
    
    private String psw;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }