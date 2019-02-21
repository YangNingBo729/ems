package com.haku.service;

import com.haku.entity.Admin;

public interface AdminService {
    boolean login(Admin admin);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Integer regist(Admin admin);
}
