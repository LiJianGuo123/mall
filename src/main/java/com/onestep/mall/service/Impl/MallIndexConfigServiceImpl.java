package com.onestep.mall.service.Impl;

import com.onestep.mall.api.vo.MallIndexConfigGoodsVO;
import com.onestep.mall.dao.GoodsCategoryMapper;
import com.onestep.mall.dao.IndexConfigMapper;
import com.onestep.mall.dao.MallGoodsMapper;
import com.onestep.mall.entity.IndexConfig;
import com.onestep.mall.entity.MallGoods;
import com.onestep.mall.service.MallIndexConfigService;
import com.onestep.mall.utils.BeanUtil;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MallIndexConfigServiceImpl implements MallIndexConfigService {

  @Resource
  IndexConfigMapper indexConfigMapper;

  @Resource
  MallGoodsMapper goodsMapper;

  @Override
  public List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number) {
    List<MallIndexConfigGoodsVO> mallIndexConfigGoodsVOS = new ArrayList<>(number);
    List<IndexConfig> indexConfigs = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
    if (!CollectionUtils.isEmpty(indexConfigs)) {
      //取出所有的goodsId
      List<Long> goodsIds = indexConfigs.stream().map(IndexConfig::getGoodsId).collect(Collectors.toList());
      List<MallGoods> newBeeMallGoods = goodsMapper.selectByPrimaryKeys(goodsIds);
      mallIndexConfigGoodsVOS = BeanUtil.copyList(newBeeMallGoods, MallIndexConfigGoodsVO.class);
      for (MallIndexConfigGoodsVO newBeeMallIndexConfigGoodsVO : mallIndexConfigGoodsVOS) {
        String goodsName = newBeeMallIndexConfigGoodsVO.getGoodsName();
        // 字符串过长导致文字超出的问题
        if (goodsName.length() > 30) {
          goodsName = goodsName.substring(0, 30) + "...";
          newBeeMallIndexConfigGoodsVO.setGoodsName(goodsName);
        }
      }
    }
    return mallIndexConfigGoodsVOS;
  }
}
