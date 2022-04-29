package vip.zhguo.eduservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.zhguo.commonutils.R;
import vip.zhguo.eduservice.entity.CheckUser;
import vip.zhguo.eduservice.entity.User;

import java.util.HashMap;

/**
 * [一句话描述该类的功能]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/29 12:37]
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public R login(@RequestBody CheckUser checkUser) {
//        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("TokenKey", "zhenghg");
        return R.ok().data(map);

    }

    @GetMapping("/info")
    public R info() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zhenghg");
        map.put("avatar","http://localhost:8001/static/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return R.ok().data(map);
    }
    @RequestMapping("/logout")
    public R logout() {
//        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("TokenKey","");
        return R.ok().data(map);
    }

}
