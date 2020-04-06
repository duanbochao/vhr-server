package com.config;

import com.bean.Menu;
import com.bean.Role;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/6 10:12
 */
@Component
public class UrlFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        if ("/login_p".equals(requestUrl)){
            return null;
        }

        List<Menu> menus = menuService.getAllMenu();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)){
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];

                for (int i = 0; i < roles.size(); i++) {
                    values[i]=roles.get(i).getName();
                }

                return SecurityConfig.createList(values);
            }
        }
       //没有匹配上的都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
