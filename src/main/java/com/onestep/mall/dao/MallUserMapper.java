package com.onestep.mall.dao;


import com.onestep.mall.entity.MallUser;
import com.onestep.mall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MallUserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long userId);

    MallUser selectByLoginName(String loginName);

    MallUser selectIdByLoginNameAndPasswordSha256
            (@Param("loginName")String loginName, @Param("passwordSha256") String passwordSha256);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

    List<MallUser> findMallUserList(PageQueryUtil pageUtil);

    int getTotalMallUsers(PageQueryUtil pageUtil);

    int lockUserBatch(@Param("ids") Integer[] ids, @Param("lockStatus") int lockStatus);
}
