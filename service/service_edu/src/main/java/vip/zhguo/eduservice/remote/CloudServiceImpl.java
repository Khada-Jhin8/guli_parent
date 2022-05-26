package vip.zhguo.eduservice.remote;

import org.springframework.stereotype.Component;
import vip.zhguo.commonutils.R;
@Component
public class CloudServiceImpl implements CloudService{
    @Override
    public R sayHello(Integer id) {
        System.out.println("调用失败了");
        return R.error().message("本地方法");
    }
}
