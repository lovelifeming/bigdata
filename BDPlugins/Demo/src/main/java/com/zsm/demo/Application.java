package com.zsm.demo;

import com.zsm.demo.utils.SensitiveInfoUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
//@PropertySource(value = {"classpath:/conf/application.yml"})
@Import({SensitiveInfoUtils.class})
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
