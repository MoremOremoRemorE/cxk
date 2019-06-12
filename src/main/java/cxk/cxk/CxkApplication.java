package cxk.cxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cxk.cxk.mapper")
@SpringBootApplication
public class CxkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxkApplication.class, args);
    }

}
