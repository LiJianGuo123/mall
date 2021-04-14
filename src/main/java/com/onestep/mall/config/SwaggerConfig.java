package com.onestep.mall.config;

import com.onestep.mall.entity.MallUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> swaggerParams = new ArrayList<Parameter>();
        tokenParam.name("satoken").description("用户认证信息")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        swaggerParams.add(tokenParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(MallUser.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.onestep.mall.api"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(swaggerParams);
    }

    public ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("api文档")
                .description("test测试")
                .version("0.1")
                .build();
    }
}
