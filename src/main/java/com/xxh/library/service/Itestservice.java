package com.xxh.library.service;

import com.xxh.library.dao.testDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public interface Itestservice {
    public void testname(String name);
    public  void testupdatebyID(int id);

}
