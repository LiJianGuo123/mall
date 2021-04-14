package com.onestep.mall.dao;

import com.onestep.mall.entity.GoodsCategory;
import com.onestep.mall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
  int deleteByPrimaryKey(Long categoryId);

  int insert(GoodsCategory record);

  int insertSelective(GoodsCategory record);

  GoodsCategory selectByPrimaryKey(Long categoryId);

  GoodsCategory selectByLevelAndName(@Param("categoryLevel") Byte categoryLevel, @Param("categoryName") String categoryName);

  int updateByPrimaryKeySelective(GoodsCategory record);

  int updateByPrimaryKey(GoodsCategory record);

  List<GoodsCategory> findGoodsCategoryList(PageQueryUtil pageUtil);

  int getTotalGoodsCategories(PageQueryUtil pageUtil);

  int deleteBatch(Long[] ids);

  List<GoodsCategory> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);
}
