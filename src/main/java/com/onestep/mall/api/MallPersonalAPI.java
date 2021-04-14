package com.onestep.mall.api;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.onestep.mall.api.param.MallUserLoginParam;
import com.onestep.mall.api.param.MallUserUpdateParam;
import com.onestep.mall.api.vo.MallUserVO;
import com.onestep.mall.entity.MallUser;
import com.onestep.mall.service.MallUserService;
import com.onestep.mall.utils.BeanUtil;
import com.onestep.mall.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "v1", tags = "商城用户操作相关接口")
@RequestMapping("/api/v1")
public class MallPersonalAPI {

  private Logger logger = LoggerFactory.getLogger(MallPersonalAPI.class);

  @Resource
  MallUserService mallUserService;

  @ApiOperation(value = "登陆接口", notes = "")
  @PostMapping("/login")
  public Result<JSONObject> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam) {
    Long loginResult = mallUserService.login(mallUserLoginParam.getLoginName(),
        mallUserLoginParam.getPasswordSha256());
    //登录成功
    if (loginResult != -1) {
      StpUtil.setLoginId(loginResult);
      SaTokenInfo saTokenInfo =  StpUtil.getTokenInfo();
      JSONObject tokenMap = new JSONObject();
      tokenMap.put("tokenName", saTokenInfo.getTokenName());
      tokenMap.put("tokenValue", saTokenInfo.getTokenValue());
      return new Result<>(tokenMap);
    }

    return new Result<>(500, null);
  }

  @GetMapping("/user/info")
  @ApiOperation(value = "获取用户信息", notes = "")
  @SaCheckLogin
  public Result<MallUserVO> getUserDetail() {
    Long userId = StpUtil.getLoginIdAsLong();
    MallUser mallUser = mallUserService.getUserById(userId);
    MallUserVO mallUserVO = new MallUserVO();
    BeanUtil.copyProperties(mallUser, mallUserVO);
    return new Result<>(mallUserVO);
  }

  @PostMapping("/user/logout")
  @ApiOperation(value = "登出接口", notes = "清除token")
  @SaCheckLogin
  public Result<String> logout() {
    Long userId = StpUtil.getLoginIdAsLong();

    StpUtil.logout();

    logger.info("logout api,loginMallUser={}", userId);

    Object obj = StpUtil.getLoginIdDefaultNull();

    if (obj == null) {
      return  new Result<>(200, "logout ");
    }

    return Result.FAIL;
  }

  @PutMapping("/user/info")
  @ApiOperation(value = "修改用户信息", notes = "")
  @SaCheckLogin
  public Result<String> updateInfo(
      @RequestBody @ApiParam("用户信息") MallUserUpdateParam mallUserUpdateParam) {

    //更新用户，根据登陆用户的UserId
    Boolean flag = mallUserService.updateUserInfo(mallUserUpdateParam, StpUtil.getLoginIdAsLong());

    if (flag) {
      return Result.SUCCESS;
    }
    return Result.FAIL;
  }

  @ApiOperation(value = "检查是否登陆接口", notes = "")
  @PostMapping("/isLogin")
  public Result<JSONObject> isLogin() {
    StpUtil.checkLogin();
    return new Result<>(200, null);
  }

  @ApiOperation(value = "查询所有登陆用户", notes = "")
  @PostMapping("/searchALlLogin")
  public Result<List<String>> searchAllLogin() {
    List<String> tokenList = StpUtil.searchTokenValue("1000", -1, 10);
    return new Result<>(tokenList);
  }

  @ApiOperation(value = "SaTokenInfo 参数", notes = "")
  @PostMapping("/searchSaTokenInfo")
  public Result<SaTokenInfo> searchSaTokenInfo() {
    SaTokenInfo saTokenInfo =  StpUtil.getTokenInfo();
    return new Result<>(saTokenInfo);
  }


}
