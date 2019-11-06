package com.zhku.mh.common.utils;

import com.zhku.mh.entities.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtil {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
