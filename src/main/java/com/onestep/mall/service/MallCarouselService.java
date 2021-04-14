package com.onestep.mall.service;

import com.onestep.mall.api.vo.MallIndexCarouselVO;

import java.util.List;

public interface MallCarouselService {

  List<MallIndexCarouselVO> getCarouselsForIndex(int number);
}
