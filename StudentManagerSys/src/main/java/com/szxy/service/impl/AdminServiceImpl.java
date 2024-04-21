package com.szxy.service.impl;

import com.szxy.eneity.Admin;
import com.szxy.mapper.AdminMapper;
import com.szxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mr.z on 2018/4/17 0017.
 * AdminServiceImpl
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdmin(String admNum) {
        return adminMapper.findAdmin(admNum);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }
}
