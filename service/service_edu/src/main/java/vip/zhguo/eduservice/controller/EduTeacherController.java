package vip.zhguo.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.zhguo.commonutils.R;
import vip.zhguo.eduservice.entity.EduTeacher;
import vip.zhguo.eduservice.service.EduTeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zhenghg
 * @since 2022-04-25
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/eduservice/eduteacher")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService;

    @GetMapping
    public R getTeachers() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("data", list);
    }


    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag)
            return R.ok();
        return R.error();
    }

    @GetMapping("/pageTeacher/{current}/{limit}")
    public R getPageTeacher(@PathVariable long current, @PathVariable long limit) {
        Page<EduTeacher> eduTeachers = new Page<EduTeacher>(current, limit);
        IPage<EduTeacher> page = eduTeacherService.page(eduTeachers, null);
        return R.ok().data("data", page);
    }

}

