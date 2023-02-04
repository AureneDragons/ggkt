package com.atguigu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {
    @ExcelProperty(value = "编号",index = 0)
    private int number;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;
}
