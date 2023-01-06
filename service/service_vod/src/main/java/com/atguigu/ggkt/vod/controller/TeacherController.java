package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.utils.GgktException;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/admin/vod/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public Result findAll(){
//        try {
//            int i = 10/0;
//        } catch (Exception e){
//            throw new GgktException(201,"出现除数自定义异常");
//        }
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return Result.ok(null);
    }

    //删除讲师
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess){
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result index(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> teacherPage = new Page<>(page,limit);

        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(joinDateBegin)){
            wrapper.ge("join_date",joinDateBegin);
        }
        if (!StringUtils.isEmpty(joinDateEnd)){
            wrapper.le("join_date",joinDateEnd);
        }

        Page<Teacher> pageModel = teacherService.page(teacherPage, wrapper);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Teacher teacher) {
        teacherService.updateById(teacher);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        teacherService.removeByIds(idList);
        return Result.ok(null);
    }
}

