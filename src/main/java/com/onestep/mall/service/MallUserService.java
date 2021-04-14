package com.onestep.mall.service;

import com.onestep.mall.api.param.MallUserUpdateParam;
import com.onestep.mall.entity.MallUser;

public interface MallUserService {

    Long login (String loginName,String passwordSha256);

    MallUser getUserById(Long id);

    Boolean updateUserInfo(MallUserUpdateParam mallUserUpdateParam,Long userId);
}
