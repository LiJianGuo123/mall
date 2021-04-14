package com.onestep.mall.service.Impl;

import com.onestep.mall.api.param.MallUserUpdateParam;
import com.onestep.mall.entity.MallUser;
import com.onestep.mall.dao.MallUserMapper;
import com.onestep.mall.service.MallUserService;
import com.onestep.mall.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class MallUserServiceImpl implements MallUserService {

    @Resource
    MallUserMapper mallUserMapper;

    @Override
    public Long login(String loginName, String passwordSha256) {
        MallUser mallUser = mallUserMapper.selectIdByLoginNameAndPasswordSha256(loginName,passwordSha256);
        if(mallUser == null){
            return -1L;//用户不存在 返回-1
        }
        if(mallUser.getIsDeleted()==1){
            return -1L;//用户已注销 返回-1
        }
        if (mallUser.getLockedFlag()==1){
            return -1L;//用户锁定 返回-1
        }
        if(mallUser.toString()==null){
            return -1L;//用户ID为空 返回-1
        }
        //返回用户ID
        return mallUser.getUserId();
    }

    @Override
    public MallUser getUserById(Long id) {
        return mallUserMapper.selectByPrimaryKey(id);//通过id 获得用户信息
    }

    @Override
    public Boolean updateUserInfo(MallUserUpdateParam mallUserUpdateParam, Long userId) {
        MallUser mallUser = new MallUser();
        BeanUtil.copyProperties(mallUserUpdateParam,mallUser);
        mallUser.setUserId(userId);//装配更新User
        int i = mallUserMapper.updateByPrimaryKeySelective(mallUser);//返回更新条数
        return i > 0;//根据更新条数来返回是否更新
    }
}
