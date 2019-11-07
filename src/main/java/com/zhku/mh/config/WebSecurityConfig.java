package com.zhku.mh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhku.mh.common.result.RespBean;
import com.zhku.mh.common.utils.HrUtil;
import com.zhku.mh.component.AuthenticationAccessDeniedHandler;
import com.zhku.mh.component.CustomMetadataSource;
import com.zhku.mh.component.UrlAccessDecisionManager;
import com.zhku.mh.service.HrService;
import com.zhku.mh.service.impl.HrServiceImpl;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomMetadataSource customMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","static/**","login_p");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(customMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/login_p").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                        AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=UTF-8");
                        RespBean respBean = null;
                        if(e instanceof BadCredentialsException || e instanceof UsernameNotFoundException){
                            respBean = RespBean.error("用户名或者密码输入错误");
                        }else if(e instanceof LockedException){
                            respBean = RespBean.error("用户已经被锁定");
                        }else if(e instanceof CredentialsExpiredException){
                            respBean = RespBean.error("密码过期，请联系管理员");
                        }else if(e instanceof AccountExpiredException){
                            respBean = RespBean.error("账户过期，请联系管理员");
                        }else if(e instanceof DisabledException){
                            respBean = RespBean.error("账户已被禁用，请联系管理员");
                        }else {
                            respBean = RespBean.error("登录失败");
                        }
                        response.setStatus(Response.SC_UNAUTHORIZED);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=UTF-8");
                        RespBean respBean = RespBean.ok("登录成功", HrUtil.getCurrentHr());
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                 .rememberMe()
                .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }


}
