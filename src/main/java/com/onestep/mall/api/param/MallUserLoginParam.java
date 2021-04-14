package com.onestep.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

public class MallUserLoginParam implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("登陆密码")
    @NotEmpty(message = "登录密码不能为空")
    private String passwordSha256;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordSha256() {
        return passwordSha256;
    }

    public void setPasswordSha256(String passwordSha256) {
        this.passwordSha256 = passwordSha256;
    }

    @Override
    public String toString() {
        return "MallUserLoginParam{" +
                "loginName='" + loginName + '\'' +
                ", passwordSha256='" + passwordSha256 + '\'' +
                '}';
    }
}
