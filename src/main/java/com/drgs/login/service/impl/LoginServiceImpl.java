package com.drgs.login.service.impl;

import com.drgs.commom.ZTBGyUtils;
import com.drgs.login.mapper.LoginMapper;
import com.drgs.login.service.LoginService;
import com.drgs.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int login(Map<String, Object> params) throws Exception {
        int loginFlag = loginMapper.login(params);
        return loginFlag;
    }
}
