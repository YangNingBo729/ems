package com.haku;

import com.haku.dao.AdminMapper;
import com.haku.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmsApplicationTests {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void contextLoads() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

}
