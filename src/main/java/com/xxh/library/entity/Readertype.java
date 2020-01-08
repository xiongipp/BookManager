package com.xxh.library.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Readertype)表实体类
 *
 * @author makejava
 * @since 2019-12-13 21:29:05
 */
@SuppressWarnings("serial")
public class Readertype extends Model<Readertype> {
    @TableId
    private Integer rdtype;
    
    private String rdtypename;
    
    private Integer canlendqty;
    
    private Integer canlendday;
    
    private Integer cancontinuetimes;
    
    private Float punishrate;
    
    private Integer datevalid;


    public Integer getRdtype() {
        return rdtype;
    }

    public void setRdtype(Integer rdtype) {
        this.rdtype = rdtype;
    }

    public String getRdtypename() {
        return rdtypename;
    }

    public void setRdtypename(String rdtypename) {
        this.rdtypename = rdtypename;
    }

    public Integer getCanlendqty() {
        return canlendqty;
    }

    public void setCanlendqty(Integer canlendqty) {
        this.canlendqty = canlendqty;
    }

    public Integer getCanlendday() {
        return canlendday;
    }

    public void setCanlendday(Integer canlendday) {
        this.canlendday = canlendday;
    }

    public Integer getCancontinuetimes() {
        return cancontinuetimes;
    }

    public void setCancontinuetimes(Integer cancontinuetimes) {
        this.cancontinuetimes = cancontinuetimes;
    }

    public Float getPunishrate() {
        return punishrate;
    }

    public void setPunishrate(Float punishrate) {
        this.punishrate = punishrate;
    }

    public Integer getDatevalid() {
        return datevalid;
    }

    public void setDatevalid(Integer datevalid) {
        this.datevalid = datevalid;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.rdtype;
    }
    }