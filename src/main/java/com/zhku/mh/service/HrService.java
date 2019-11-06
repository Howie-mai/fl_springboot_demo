package com.zhku.mh.service;

import com.zhku.mh.common.BaseService;
import com.zhku.mh.entities.Hr;
import com.zhku.mh.entities.HrExample;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface HrService extends BaseService<Hr, HrExample, Integer>, UserDetailsService {
}