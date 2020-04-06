package com.controller;

import com.bean.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/6 11:16
 */
@RestController
public class RegLoginController {

    @RequestMapping("/login_p")
    public RespBean login(){
        return new RespBean().err("尚未登录，请登录!");
    }
}
