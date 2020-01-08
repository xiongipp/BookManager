package com.xxh.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.library.dao.BorrowDao;
import com.xxh.library.entity.Borrow;
import com.xxh.library.service.BorrowService;
import org.springframework.stereotype.Service;

/**
 * (Borrow)表服务实现类
 *
 * @author makejava
 * @since 2019-12-15 15:19:53
 */
@Service("borrowService")
public class BorrowServiceImpl extends ServiceImpl<BorrowDao, Borrow> implements BorrowService {

}