package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vod.mapper.SubjectMapper;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-01-05
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectList(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);
        //向list集合每个Subject对象中设置hasChildren
        for (Subject subject:subjectList) {
            Long subjectId = subject.getId();
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        }
        return subjectList;
    }

    //判断id下面是否有子节点
    private boolean isChildren(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        return count>0;
    }
}
