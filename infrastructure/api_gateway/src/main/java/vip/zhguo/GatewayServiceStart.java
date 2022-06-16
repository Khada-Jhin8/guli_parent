package vip.zhguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * [启动类]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/6/16 16:46]
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceStart.class,args);
    }
}
