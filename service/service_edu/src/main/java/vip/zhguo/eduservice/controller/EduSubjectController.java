package vip.zhguo.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import vip.zhguo.commonutils.R;
import vip.zhguo.eduservice.entity.EduSubject;
import vip.zhguo.eduservice.service.EduSubjectService;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zhenghg
 * @since 2022-05-18
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/subject")
public class EduSubjectController {

    @Autowired
    EduSubjectService eduSubjectService;
    @GetMapping
    public R getSubjects(){
        List subjests = eduSubjectService.getAllSubjectMenu();
        return R.ok().data(subjests);
    }

}

