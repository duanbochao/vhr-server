package com.mapper;

import com.bean.Hr;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/5 19:04
 */
public interface HrMapper {

    Hr loadUserByUsername(String username);
}
