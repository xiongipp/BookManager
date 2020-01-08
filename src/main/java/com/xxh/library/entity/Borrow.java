package com.xxh.library.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Borrow)表实体类
 *
 * @author makejava
 * @since 2019-12-15 15:19:53
 */
@SuppressWarnings("serial")
public class Borrow extends Model<Borrow> {
    @TableId(type = IdType.AUTO)
    private Integer borrowid;
    
    private Integer rdid;
    
    private Integer bkid;
    
    private Integer idcountinuetimes;
    
    private Date lddateout;
    
    private Date lddateretplan;
    
    private Date lddateretact;
    
    private Integer ldoverday;
    
    private Integer ldovermoney;
    
    private Object ishasreturn;
    
    private String operatorlend;
    
    private String operatorret;

    private String bookname;
    private String authorname;

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Integer borrowid) {
        this.borrowid = borrowid;
    }

    public Integer getRdid() {
        return rdid;
    }

    public void setRdid(Integer rdid) {
        this.rdid = rdid;
    }

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public Integer getIdcountinuetimes() {
        return idcountinuetimes;
    }

    public void setIdcountinuetimes(Integer idcountinuetimes) {
        this.idcountinuetimes = idcountinuetimes;
    }

    public Date getLddateout() {
        return lddateout;
    }

    public void setLddateout(Date lddateout) {
        this.lddateout = lddateout;
    }

    public Date getLddateretplan() {
        return lddateretplan;
    }

    public void setLddateretplan(Date lddateretplan) {
        this.lddateretplan = lddateretplan;
    }

    public Date getLddateretact() {
        return lddateretact;
    }

    public void setLddateretact(Date lddateretact) {
        this.lddateretact = lddateretact;
    }

    public Integer getLdoverday() {
        return ldoverday;
    }

    public void setLdoverday(Integer ldoverday) {
        this.ldoverday = ldoverday;
    }

    public Integer getLdovermoney() {
        return ldovermoney;
    }

    public void setLdovermoney(Integer ldovermoney) {
        this.ldovermoney = ldovermoney;
    }

    public Object getIshasreturn() {
        return ishasreturn;
    }

    public void setIshasreturn(Object ishasreturn) {
        this.ishasreturn = ishasreturn;
    }

    public String getOperatorlend() {
        return operatorlend;
    }

    public void setOperatorlend(String operatorlend) {
        this.operatorlend = operatorlend;
    }

    public String getOperatorret() {
        return operatorret;
    }

    public void setOperatorret(String operatorret) {
        this.operatorret = operatorret;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.borrowid;
    }
    }