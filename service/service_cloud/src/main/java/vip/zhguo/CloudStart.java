package vip.zhguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "vip.zhguo")
@EnableDiscoveryClient
public class CloudStart {
    public static void main(String[] args) {
        SpringApplication.run(CloudStart.class,args);
    }
}
