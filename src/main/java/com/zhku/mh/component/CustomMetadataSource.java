package com.zhku.mh.component;

import com.zhku.mh.entities.DTO.MenuDTO;
import com.zhku.mh.entities.Menu;
import com.zhku.mh.entities.Role;
import com.zhku.mh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<MenuDTO> menuList = menuService.getAllMenu();
        for (MenuDTO menu:menuList){
            if(antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size()>0){
                List<Role> roles = menu.getRoles();
                String[] values = new String[roles.size()];
                for(int i = 0;i<values.length;i++){
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
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
