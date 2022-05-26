package vip.zhguo.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.zhguo.commonutils.R;
import vip.zhguo.eduservice.entity.EduTeacher;
import vip.zhguo.eduservice.entity.vo.TeacherQuery;
import vip.zhguo.eduservice.remote.CloudService;
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
@CrossOrigin
@RestController
@RequestMapping("/edu/teacher")
@ApiModel("讲师类接口")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService;


    @Autowired
    CloudService cloudService;

    @GetMapping
    @ApiOperation("获取所有教师")
    public R getTeachers() {
        List<EduTeacher> list = eduTeacherService.list(null);
        R r = cloudService.sayHello(12314);
        System.out.println(r.getData());
        return R.ok().data(list);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id获取教师")
    public R getTeacher(@PathVariable String id) {
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data(teacher);
    }


    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除教师")
    public R deleteById(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag)
            return R.ok();
        return R.error();
    }

    @PostMapping("/{current}/{limit}")
    @ApiOperation("条件分页查询教师信息")
    public R getPageTeacher(@PathVariable long current,
                            @PathVariable long limit,
                            @RequestBody(required = false) EduTeacher eduTeacher) {
        Page<EduTeacher> eduTeachers = new Page<EduTeacher>(current, limit);
        //封装查询条件
        LambdaQueryWrapper<EduTeacher> lqw = new LambdaQueryWrapper();
        lqw.like(eduTeacher.getName() != null, EduTeacher::getName, eduTeacher.getName());
        lqw.eq(eduTeacher.getLevel() != null, EduTeacher::getLevel, eduTeacher.getLevel());
//        lqw.eq(eduTeacher.getGmtCreate() != null, EduTeacher::getGmtCreate, eduTeacher.getGmtCreate());
        lqw.orderByDesc(EduTeacher::getGmtCreate);
        IPage<EduTeacher> page = eduTeacherService.page(eduTeachers, lqw);
        return R.ok().data(page);
    }

    @ApiOperation("新增教师")
    @PostMapping
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save)
            return R.ok();
        return R.error();

    }

    @ApiOperation("修改教师")
    @PutMapping
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag)
            return R.ok();
        return R.error();
    }

}

