package com.test;

import com.bean.RespBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.HrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/5 21:15
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAPITest {

    @Autowired
    HrService hrService;

    @Test
    public void test(){
        UserDetails admin = hrService.loadUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void test1(){
        ObjectMapper om = new ObjectMapper();
        String hello = null;
        try {
            hello = om.writeValueAsString(new RespBean().ok("hello"));
            System.out.println(new RespBean().ok("hello"));
            System.out.println(hello);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
