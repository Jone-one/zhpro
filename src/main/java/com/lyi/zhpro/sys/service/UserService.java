package com.lyi.zhpro.sys.service;

import com.lyi.zhpro.sys.vo.UserVo;
import org.springframework.stereotype.Service;


public interface UserService {
    UserVo getUserByAccount(String account);
}
