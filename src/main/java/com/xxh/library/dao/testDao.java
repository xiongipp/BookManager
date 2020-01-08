package com.xxh.library.dao;

import com.xxh.library.entity.test;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

public interface testDao {
    @Select("select * from test where name=#{name}")
    public test findByName(@Param("name") String name);

    @Update("update test set num=num+1 where id=#{id} ")
    public int updateById(@Param("id")int id);
}
