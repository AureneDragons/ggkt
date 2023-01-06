package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-01-05
 */
@Api(tags = "课程分类管理")
@RestController
@RequestMapping("admin/vod/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation("查询下一层的课程分类")
    @GetMapping("getChildSubject/{id}")
    public Result getChildrenSubject(@PathVariable Long id){
        List<Subject> list = subjectService.selectList(id);
        return Result.ok(list);
    }
}

