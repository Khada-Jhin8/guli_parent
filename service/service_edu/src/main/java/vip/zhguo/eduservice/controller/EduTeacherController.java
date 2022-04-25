package vip.zhguo.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List getTeachers() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }


    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }

}

