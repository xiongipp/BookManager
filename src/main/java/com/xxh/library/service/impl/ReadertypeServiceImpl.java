package com.xxh.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.library.dao.ReadertypeDao;
import com.xxh.library.entity.Readertype;
import com.xxh.library.service.ReadertypeService;
import org.springframework.stereotype.Service;

/**
 * (Readertype)表服务实现类
 *
 * @author makejava
 * @since 2019-12-13 21:29:05
 */
@Service("readertypeService")
public class ReadertypeServiceImpl extends ServiceImpl<ReadertypeDao, Readertype> implements ReadertypeService {

}