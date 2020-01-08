package com.xxh.library.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Book)表实体类
 *
 * @author makejava
 * @since 2019-12-14 12:13:40
 */
@SuppressWarnings("serial")
public class Book extends Model<Book> {
    @TableId(type = IdType.AUTO)
    private Integer bkid;
    private String bkname;
    private String bkauthor;
    private String bkpress;
    private Date bkdatepress;
    
    private String bkcatalog;
    
    private String bkisbn;
    
    private Integer bklanguage;
    
    private Integer bkpages;
    
    private Integer bkprice;
    
    private Date bkdatein;
    
    private String bkbrief;
    
    private String bkcover;
    
    private String bkstatus;
    
    private String bkcode;

    @Override
    public String toString() {
        return "Book{" +
                "bkid=" + bkid +
                ", bkname='" + bkname + '\'' +
                ", bkauthor='" + bkauthor + '\'' +
                ", bkpress='" + bkpress + '\'' +
                ", bkdatepress=" + bkdatepress +
                ", bkcatalog='" + bkcatalog + '\'' +
                ", bkisbn='" + bkisbn + '\'' +
                ", bklanguage=" + bklanguage +
                ", bkpages=" + bkpages +
                ", bkprice=" + bkprice +
                ", bkdatein=" + bkdatein +
                ", bkbrief='" + bkbrief + '\'' +
                ", bkcover='" + bkcover + '\'' +
                ", bkstatus='" + bkstatus + '\'' +
                ", bkcode='" + bkcode + '\'' +
                '}';
    }

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getBkauthor() {
        return bkauthor;
    }

    public void setBkauthor(String bkauthor) {
        this.bkauthor = bkauthor;
    }

    public String getBkpress() {
        return bkpress;
    }

    public void setBkpress(String bkpress) {
        this.bkpress = bkpress;
    }

    public Date getBkdatepress() {
        return bkdatepress;
    }

    public void setBkdatepress(Date bkdatepress) {
        this.bkdatepress = bkdatepress;
    }

    public String getBkcatalog() {
        return bkcatalog;
    }

    public void setBkcatalog(String bkcatalog) {
        this.bkcatalog = bkcatalog;
    }

    public String getBkisbn() {
        return bkisbn;
    }

    public void setBkisbn(String bkisbn) {
        this.bkisbn = bkisbn;
    }

    public Integer getBklanguage() {
        return bklanguage;
    }

    public void setBklanguage(Integer bklanguage) {
        this.bklanguage = bklanguage;
    }

    public Integer getBkpages() {
        return bkpages;
    }

    public void setBkpages(Integer bkpages) {
        this.bkpages = bkpages;
    }

    public Integer getBkprice() {
        return bkprice;
    }

    public void setBkprice(Integer bkprice) {
        this.bkprice = bkprice;
    }

    public Date getBkdatein() {
        return bkdatein;
    }

    public void setBkdatein(Date bkdatein) {
        this.bkdatein = bkdatein;
    }

    public String getBkbrief() {
        return bkbrief;
    }

    public void setBkbrief(String bkbrief) {
        this.bkbrief = bkbrief;
    }

    public String getBkcover() {
        return bkcover;
    }

    public void setBkcover(String bkcover) {
        this.bkcover = bkcover;
    }

    public String getBkstatus() {
        return bkstatus;
    }

    public void setBkstatus(String bkstatus) {
        this.bkstatus = bkstatus;
    }

    public String getBkcode() {
        return bkcode;
    }

    public void setBkcode(String bkcode) {
        this.bkcode = bkcode;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.bkid;
    }
    }