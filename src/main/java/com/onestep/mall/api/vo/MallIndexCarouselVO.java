package com.onestep.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 首页轮播图VO
 */
public class MallIndexCarouselVO implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("轮播图点击后的跳转路径")
    private String redirectUrl;

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
