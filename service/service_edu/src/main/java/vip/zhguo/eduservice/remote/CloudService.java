package vip.zhguo.eduservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vip.zhguo.commonutils.R;

@FeignClient(name = "service-cloud",fallback = CloudServiceImpl.class)
public interface CloudService {
    @GetMapping("/hello/sayHello/{id}")
    public R sayHello(@PathVariable Integer id);

}
