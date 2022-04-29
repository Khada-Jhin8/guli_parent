package vip.zhguo.eduservice.entity;

import lombok.Data;

/**
 * [用户]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/29 16:50]
 */
@Data
public class User {
    private String name;
    private String avatar;
    private String token;
    private String device;
    private String sidebar;

    public User(String name, String token) {
        this.name = name;
        this.token = token;
    }
}
