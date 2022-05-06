package vip.zhguo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * [一句话描述该类的功能]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/6 15:19]
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class ConstantProperties {
    private String AccessKeyID;
    private String AccessKeySecret;
    private String bucKetName;
    private String endpoint;
}
