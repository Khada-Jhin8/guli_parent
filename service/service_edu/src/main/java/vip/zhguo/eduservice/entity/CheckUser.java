package vip.zhguo.eduservice.entity;

import lombok.Data;

/**
 * [登录用户账号-临时]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/29 12:49]
 */
@Data
public class CheckUser {
    private String username;
    private String password;
}
