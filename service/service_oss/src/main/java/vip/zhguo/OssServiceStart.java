package vip.zhguo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * [启动类]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/25 13:58]
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "vip.zhguo")
//@ComponentScan(basePackages = "vip.zhguo")
public class OssServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(OssServiceStart.class,args);
    }
}
