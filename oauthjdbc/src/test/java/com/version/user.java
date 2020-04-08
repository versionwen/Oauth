package com.version;

import com.version.entity.TbUser;
import com.version.service.TbUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/7 16:41
 */
@SpringBootTest
public class user {
    @Resource
    private TbUserService tbUserService;
    @Test
    public void query(){
        System.out.println(tbUserService.queryById(1L));
    }
}
