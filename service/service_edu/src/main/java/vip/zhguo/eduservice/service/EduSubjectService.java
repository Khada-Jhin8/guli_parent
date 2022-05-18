package vip.zhguo.eduservice.service;

import vip.zhguo.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zhenghg
 * @since 2022-05-18
 */
public interface EduSubjectService extends IService<EduSubject> {

    List getAllSubjectMenu();
}
