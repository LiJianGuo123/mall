package com.onestep.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MallUser {

    //用户主键ID
    private Long userId;
    //用户姓名
    private String mallName;
    //登陆名称-手机号或邮箱等
    private String loginName;
    //登陆密码 sha256加密
    private String passwordSha256;
    //个性签名
    private String introduceSign;
    //是否注销标识
    private Byte isDeleted;
    //是否锁定标识
    private Byte lockedFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getPasswordSha256() {
        return passwordSha256;
    }

    public void setPasswordSha256(String passwordSha256) {
        this.passwordSha256 = passwordSha256;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Byte getLockedFlag() {
        return lockedFlag;
    }

    public void setLockedFlag(Byte lockedFlag) {
        this.lockedFlag = lockedFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MallUser{" +
                "userId=" + userId +
                ", mallName='" + mallName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passwordSha256='" + passwordSha256 + '\'' +
                ", introduceSign='" + introduceSign + '\'' +
                ", isDeleted=" + isDeleted +
                ", lockedFlag=" + lockedFlag +
                ", createTime=" + createTime +
                '}';
    }
}
