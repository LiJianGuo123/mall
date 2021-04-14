package com.onestep.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;

public class MallUserVO {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("用户昵称")
    private String mallName;

    @ApiModelProperty("用户登陆名")
    private String loginName;

    @ApiModelProperty("个性签名")
    private String introduceSign;

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }
}
