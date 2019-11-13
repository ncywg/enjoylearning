package practice;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//自动配置功能 已经包含在SpringBootApplication 功能中
//@EnableAutoConfiguration
@EnableTransactionManagement
@MapperScan("practice.mapper")
public class App {
    public static void main(String[] args) {
        //启动类
        //定制化
        SpringApplication.run(App.class, args);
    }
}
