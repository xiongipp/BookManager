package com.xxh.library.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Reader)表实体类
 *
 * @author makejava
 * @since 2019-12-09 22:09:08
 */
@SuppressWarnings("serial")
public class Reader extends Model<Reader> {
    @TableId()
    private Integer rdid;
    
    private String rdname;
    
    private String rdsex;
    
    private Integer rdtype;
    
    private String rddept;
    
    private String rdphone;
    
    private String rdemil;
    
    private Date rddatereg;
    
    private String rdphoto;
    
    private String rdstatus;
    
    private Integer rdborrowqty;
    
    private String rdpwd;
    
    private Integer rdadminroles;


    public Integer getRdid() {
        return rdid;
    }

    public void setRdid(Integer rdid) {
        this.rdid = rdid;
    }

    public String getRdname() {
        return rdname;
    }

    public void setRdname(String rdname) {
        this.rdname = rdname;
    }

    public String getRdsex() {
        return rdsex;
    }

    public void setRdsex(String rdsex) {
        this.rdsex = rdsex;
    }

    public Integer getRdtype() {
        return rdtype;
    }

    public void setRdtype(Integer rdtype) {
        this.rdtype = rdtype;
    }

    public String getRddept() {
        return rddept;
    }

    public void setRddept(String rddept) {
        this.rddept = rddept;
    }

    public String getRdphone() {
        return rdphone;
    }

    public void setRdphone(String rdphone) {
        this.rdphone = rdphone;
    }

    public String getRdemil() {
        return rdemil;
    }

    public void setRdemil(String rdemil) {
        this.rdemil = rdemil;
    }

    public Date getRddatereg() {
        return rddatereg;
    }

    public void setRddatereg(Date rddatereg) {
        this.rddatereg = rddatereg;
    }

    public String getRdphoto() {
        return rdphoto;
    }

    public void setRdphoto(String rdphoto) {
        this.rdphoto = rdphoto;
    }

    public String getRdstatus() {
        return rdstatus;
    }

    public void setRdstatus(String rdstatus) {
        this.rdstatus = rdstatus;
    }

    public Integer getRdborrowqty() {
        return rdborrowqty;
    }

    public void setRdborrowqty(Integer rdborrowqty) {
        this.rdborrowqty = rdborrowqty;
    }

    public String getRdpwd() {
        return rdpwd;
    }

    public void setRdpwd(String rdpwd) {
        this.rdpwd = rdpwd;
    }

    public Integer getRdadminroles() {
        return rdadminroles;
    }

    public void setRdadminroles(Integer rdadminroles) {
        this.rdadminroles = rdadminroles;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.rdid;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rdid=" + rdid +
                ", rdname='" + rdname + '\'' +
                ", rdsex='" + rdsex + '\'' +
                ", rdtype=" + rdtype +
                ", rddept='" + rddept + '\'' +
                ", rdphone='" + rdphone + '\'' +
                ", rdemil='" + rdemil + '\'' +
                ", rddatereg=" + rddatereg +
                ", rdphoto='" + rdphoto + '\'' +
                ", rdstatus='" + rdstatus + '\'' +
                ", rdborrowqty=" + rdborrowqty +
                ", rdpwd='" + rdpwd + '\'' +
                ", rdadminroles=" + rdadminroles +
                '}';
    }
}