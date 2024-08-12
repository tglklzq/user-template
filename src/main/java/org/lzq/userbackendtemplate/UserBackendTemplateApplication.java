package org.lzq.userbackendtemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.lzq.userbackendtemplate.mapper")
public class UserBackendTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserBackendTemplateApplication.class, args);
    }

}
