package com.bean.utils;

import com.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/5 21:43
 * 获取系统当前登录用户信息
 */
public class HrUtils {

    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
