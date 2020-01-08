package com.xxh.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.library.dao.AdminDao;
import com.xxh.library.entity.Admin;
import com.xxh.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2019-12-27 12:33:34
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

}