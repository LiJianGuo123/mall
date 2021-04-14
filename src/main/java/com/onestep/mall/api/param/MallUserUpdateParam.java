package com.onestep.mall.api.param;

import io.swagger.annotations.ApiModelProperty;

public class MallUserUpdateParam {

    @ApiModelProperty("用户昵称")
    private String mallName;
    @ApiModelProperty("用户密码-256加密")
    private String passwdSha256;
    @ApiModelProperty("个性签名")
    private String introduceSign;

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getPasswdSha256() {
        return passwdSha256;
    }

    public void setPasswdSha256(String passwdSha256) {
        this.passwdSha256 = passwdSha256;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }
}
