package com.zhku.mh.common.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;

import com.zhku.mh.common.utils.JwtUtil;
import io.jsonwebtoken.lang.Strings;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：
 * Time：2019/11/7 17:00
 * Description：
 * Author： mh
 */
public class AuthFilter extends BasicAuthenticationFilter {
    public AuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //从header 中提取token
        String token = request.getHeader("Authorization");

        try {
            //假如token 为空,不生成authentication
            if (!StringUtils.isEmpty(token)) {
                String decode = JwtUtil.decode(Strings.JWT_KEY, token);
                if (!StringUtils.isEmpty(decode)) {
                    UserBean userBean = JSON.parseObject(decode, UserBean.class);

                    String username = userBean.getUsername();

                    List<GrantedAuthority> permissions = new ArrayList<>();
                    // TODO: 查询用户权限,默认无权限

                    //验证正常,生成authentication
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userBean, "", permissions));
                }
            }
        } catch (Exception e) {
            log.error(Throwables.getStackTraceAsString(e));
        } finally {
            //让spring security 继续执行
            chain.doFilter(request, response);
        }
    }
    }
}
