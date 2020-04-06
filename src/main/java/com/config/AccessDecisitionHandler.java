package com.config;

import com.bean.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/6 11:11
 */
@Component
public class AccessDecisitionHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);//403
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        RespBean respBean = new RespBean();
        RespBean err = respBean.err("权限不足，请联系管理员!");
        writer.write(new ObjectMapper().writeValueAsString(err));
        writer.flush();
        writer.close();
    }
}
