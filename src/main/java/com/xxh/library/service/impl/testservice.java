package com.xxh.library.service.impl;

import com.xxh.library.dao.testDao;
import com.xxh.library.entity.test;
import com.xxh.library.service.Itestservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class testservice implements Itestservice {
    @Autowired
    private testDao testMapper;
    @Override
    public void testname(String name) {
        test Name = testMapper.findByName(name);
        if(Name==null){
            System.out.println("查不到");
        }
        else {
            System.out.println("这是我的名字"+Name.getName());

        }
    }

    @Override
    public void testupdatebyID(int id) {
        int succ = testMapper.updateById(id);
        System.out.println(succ);
    }
}
