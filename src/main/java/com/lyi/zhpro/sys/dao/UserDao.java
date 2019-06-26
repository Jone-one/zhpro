package com.lyi.zhpro.sys.dao;

import com.lyi.zhpro.sys.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    UserVo getUserByAccount(@Param(value = "account") String account);
}
