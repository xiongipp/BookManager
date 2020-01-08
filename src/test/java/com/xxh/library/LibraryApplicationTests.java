package com.xxh.library;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxh.library.dao.testDao;
import com.xxh.library.entity.Book;
import com.xxh.library.entity.Reader;
import com.xxh.library.service.BookService;
import com.xxh.library.service.Itestservice;
import com.xxh.library.service.ReaderService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LibraryApplicationTests {


    @Resource
    private ReaderService readerService;
    @Autowired
    private Itestservice itestservice;

    @Resource
    private BookService bookService;

    @Test
    void contextLoads() {
    }
    @Test
    public void testjdbc(){
        System.out.println("开始测试");
        QueryWrapper<Reader>wrapper=new QueryWrapper<>();
        wrapper.like("rdName","张");
        List<Reader> readerList = readerService.list(wrapper);
        for(Reader reader:readerList){
            System.out.println(reader.toString());
        }
    }
    @Test
    public void testmb(){
         itestservice.testname("小菜鸡");
    }

    @Test
    public void updateByID(){
        itestservice.testupdatebyID(1);
    }
    @Test
    public void updateReaderByID(){
        Reader reader = new Reader();
    }
    @Test
    public  void testDate(){
        Date date = new Date();
        Date re= DateUtils.addDays(date,10);
        System.out.println(date.before(re));
    }
    @Test
    public void testbook(){
        Book book = bookService.getById(1);
        System.out.println(book.toString());
    }



}

