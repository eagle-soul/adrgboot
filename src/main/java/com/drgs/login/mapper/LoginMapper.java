package com.drgs.login.mapper;

import com.drgs.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface LoginMapper {

    int login(Map<String,Object> params) throws Exception;
}
