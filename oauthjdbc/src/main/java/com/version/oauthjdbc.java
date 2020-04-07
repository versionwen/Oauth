package com.version;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/5 16:09
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class oauthjdbc {
    public static void main(String[] args) {
        SpringApplication.run(oauthjdbc.class,args);
    }
}
