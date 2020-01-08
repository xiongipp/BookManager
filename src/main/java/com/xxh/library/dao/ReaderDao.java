package com.xxh.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxh.library.entity.Reader;
import org.apache.ibatis.annotations.Update;

/**
 * (Reader)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-09 22:09:10
 */
public interface ReaderDao extends BaseMapper<Reader> {
    @Update("update reader set rdBorrowQty=rdBorrowQty+1 where rdId=#{id}")
   int increaseBorrowNum(int id);
}