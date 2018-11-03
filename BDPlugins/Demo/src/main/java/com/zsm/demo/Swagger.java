package com.zsm.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger2的配置文件，建在项目的启动类的同级目录下,访问路径：http://localhost:8080/swagger-ui.html
 *
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/9/1.
 * @Modified By:
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.zsm.demo")
public class Swagger
{
    @Bean
    public Docket createdRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //为当前包路径
            .apis(RequestHandlerSelectors.basePackage("com.zsm.demo.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
            //页面标题
            .title("主题数据库接口测试文档")
            //创建人
            .contact(new Contact("zsm", "", ""))
            //版本号
            .version("1.0.0")
            //描述
            .description("API文档描述")
            .build();
    }
}
