package vip.zhguo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * [跨域配置]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/6/16 16:50]
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");

         UrlBasedCorsConfigurationSource source = new
              UrlBasedCorsConfigurationSource(new PathPatternParser());
         source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
