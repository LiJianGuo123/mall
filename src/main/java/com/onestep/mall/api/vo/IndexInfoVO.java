package com.onestep.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 首页List
 */
public class IndexInfoVO implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("轮播图(列表)")
    private List<MallIndexCarouselVO> carousels;

    @ApiModelProperty("首页热销商品(列表)")
    private List<MallIndexConfigGoodsVO> hotGoodses;

    @ApiModelProperty("首页新品推荐(列表)")
    private List<MallIndexConfigGoodsVO> newGoodses;

    @ApiModelProperty("首页推荐商品(列表)")
    private List<MallIndexConfigGoodsVO> recommendGoodses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<MallIndexCarouselVO> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<MallIndexCarouselVO> carousels) {
        this.carousels = carousels;
    }

    public List<MallIndexConfigGoodsVO> getHotGoodses() {
        return hotGoodses;
    }

    public void setHotGoodses(List<MallIndexConfigGoodsVO> hotGoodses) {
        this.hotGoodses = hotGoodses;
    }

    public List<MallIndexConfigGoodsVO> getNewGoodses() {
        return newGoodses;
    }

    public void setNewGoodses(List<MallIndexConfigGoodsVO> newGoodses) {
        this.newGoodses = newGoodses;
    }

    public List<MallIndexConfigGoodsVO> getRecommendGoodses() {
        return recommendGoodses;
    }

    public void setRecommendGoodses(List<MallIndexConfigGoodsVO> recommendGoodses) {
        this.recommendGoodses = recommendGoodses;
    }
}
