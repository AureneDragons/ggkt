package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

public class TestRead {
    public static void main(String[] args) {
        String file = "D:\\下载解压临时存放\\atguiguTest.xlsx";
        EasyExcel.read(file,User.class,new ExcelListener()).sheet().doRead();
    }
}
