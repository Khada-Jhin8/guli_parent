package vip.zhguo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.zhguo.commonutils.R;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/sayHello/{id}")
    public R sayHello(@PathVariable Integer id){
        System.out.println("hello:"+id);
        return R.ok().data("我是cloud");
    }
}
