package vip.zhguo.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [配置类]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/25 13:56]
 */
@Configuration
@MapperScan("vip.zhenghg.eduservice.mapper")
public class EduConfig {
    /*设置逻辑删除*/
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();

    }
    /*设置分页*/
    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        return new PaginationInterceptor();
    }
}
