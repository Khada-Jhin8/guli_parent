package vip.zhguo.eduservice.vo;

import lombok.Data;

import java.util.List;

/**
 * [课程目录封装]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/18 15:58]
 */
@Data
public class SubjectMenu {
    private String id;
    private String title;
    private String parent_id;
    private List children;
}
