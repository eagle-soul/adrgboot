package com.drgs.login.service;

import com.drgs.vo.UserVo;

import java.util.Map;

public interface LoginService {
    int login(Map<String,Object> params) throws Exception;
}
