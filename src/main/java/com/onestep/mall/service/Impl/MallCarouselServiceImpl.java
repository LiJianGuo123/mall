package com.onestep.mall.service.Impl;

import com.onestep.mall.api.vo.MallIndexCarouselVO;
import com.onestep.mall.dao.CarouselMapper;
import com.onestep.mall.entity.Carousel;
import com.onestep.mall.service.MallCarouselService;
import com.onestep.mall.utils.BeanUtil;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MallCarouselServiceImpl implements MallCarouselService {

  @Resource
  CarouselMapper carouselMapper;

  @Override
  public List<MallIndexCarouselVO> getCarouselsForIndex(int number) {
    List<MallIndexCarouselVO> MallIndexCarouselVOS = new ArrayList<>(number);
    List<Carousel> carousels = carouselMapper.findCarouselsByNum(number);
    if (!CollectionUtils.isEmpty(carousels)) {
      MallIndexCarouselVOS = BeanUtil.copyList(carousels, MallIndexCarouselVO.class);
    }
    return MallIndexCarouselVOS;
  }
}
