package com.onestep.mall.service;

import com.onestep.mall.api.vo.MallIndexConfigGoodsVO;

import java.util.List;

public interface MallIndexConfigService {

  List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);
}
