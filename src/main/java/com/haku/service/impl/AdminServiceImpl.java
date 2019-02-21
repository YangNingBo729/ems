package com.haku.service.impl;

import com.haku.dao.AdminMapper;
import com.haku.entity.Admin;
import com.haku.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean login(Admin admin) {
        Admin admin1 = adminMapper.selectByUsername(admin.getUsername());
        if(admin1 == null) return false;
        if(admin1.getPassword().equals(admin.getPassword())) return true;
        return false;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer regist(Admin admin) {
        return adminMapper.regist(admin);
    }
}
