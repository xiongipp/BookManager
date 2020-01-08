package com.xxh.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.library.dao.ReaderDao;
import com.xxh.library.entity.Reader;
import com.xxh.library.service.ReaderService;
import org.springframework.stereotype.Service;

/**
 * (Reader)表服务实现类
 *
 * @author makejava
 * @since 2019-12-09 22:09:11
 */
@Service("readerService")
public class ReaderServiceImpl extends ServiceImpl<ReaderDao, Reader> implements ReaderService {

}