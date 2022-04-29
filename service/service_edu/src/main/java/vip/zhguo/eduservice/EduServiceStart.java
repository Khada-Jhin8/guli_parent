package vip.zhguo.eduservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * [启动类]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/25 13:58]
 */
@SpringBootApplication
@ComponentScan(basePackages = "vip.zhguo")
public class EduServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceStart.class,args);
    }
}
