package vip.zhguo.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import vip.zhguo.eduservice.entity.EduSubject;
import vip.zhguo.eduservice.mapper.EduSubjectMapper;
import vip.zhguo.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.zhguo.eduservice.vo.SubjectMenu;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author zhenghg
 * @since 2022-05-18
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    SubjectMenu subjectMenu = new SubjectMenu();
    List<SubjectMenu> subjectMenusOne = new ArrayList();
//    List<SubjectMenu>  subjectMenusTwo = new ArrayList();

    @Override
    public List getAllSubjectMenu() {
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("parent_id",0);
//        List subOne = baseMapper.selectList(qw);
//        for (Object o : subOne) {
//            BeanUtils.copyProperties( o ,subjectMenu);
//            subjectMenus.add(subjectMenu);
//        }
//        return subjectMenus;
        List<EduSubject> eduSubjects = baseMapper.selectList(null);
        // 遍历目录
        for (EduSubject eduSubject : eduSubjects) {
        // 一级目录
            if (eduSubject.getParentId().equals("0") ) {
                BeanUtils.copyProperties(eduSubject, subjectMenu);
                subjectMenusOne.add(subjectMenu);
            }
//            else {
//        // 二级目录
//                BeanUtils.copyProperties(eduSubject, subjectMenu);
//                subjectMenusTwo.add(subjectMenu);
//            }
        // 将二级目录添加到一级目录
//            for (SubjectMenu menuOne : subjectMenusOne) {
//                for (SubjectMenu menuTwo : subjectMenusTwo) {
//                    if (menuTwo.getParent_id()==menuOne.getParent_id()){
//                        menuOne.setChildren(menuTwo);
//                    }
//                }
//            }
        }
        System.out.println(subjectMenusOne);
        for (SubjectMenu menu : subjectMenusOne) {
            List tempList = new ArrayList();
            for (EduSubject eduSubject : eduSubjects) {
                if (eduSubject.getParentId().equals(menu.getId())){
                    BeanUtils.copyProperties(eduSubject,subjectMenu);
                    tempList.add(subjectMenu);
                }
            }
            menu.setChildren(tempList);
        }
        System.out.println(subjectMenusOne);
        return subjectMenusOne;
    }
}