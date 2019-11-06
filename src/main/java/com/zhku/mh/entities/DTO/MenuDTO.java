package com.zhku.mh.entities.DTO;

import com.zhku.mh.entities.Menu;
import com.zhku.mh.entities.Role;

import java.util.List;

public class MenuDTO extends Menu {
    private List<Role> roles;
    private List<MenuDTO> children;
    private MenuMeta meta;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<MenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDTO> children) {
        this.children = children;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "roles=" + roles +
                ", children=" + children +
                ", meta=" + meta +
                '}';
    }
}
