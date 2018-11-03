package com.zsm.phoenix;

import com.zsm.phoenix.conn.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
//@PropertySource(value = {"classpath:/conf/application.yml"})
//@EnableAutoConfiguration
public class Application
{
//    public static void main(String[] args)
//    {
//        SpringApplication.run(Application.class, args);
//    }

    public static void main(String[] args)throws SQLException
    {
        Connector.connect("select \"ROW\",\"cf\".\"bt\",\"cf\".\"kt\",\"cf\".\"name\",\"cf\".\"id\"  from \"BIGDATA_SP_CORE\" limit 10");
    }
}
