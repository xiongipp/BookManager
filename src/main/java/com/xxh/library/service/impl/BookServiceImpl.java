package com.xxh.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.library.dao.BookDao;
import com.xxh.library.entity.Book;
import com.xxh.library.service.BookService;
import org.springframework.stereotype.Service;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2019-12-14 12:13:40
 */
@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

}