package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestWrite {
    public static void main(String[] args) {
        String fileName = "D:\\下载解压临时存放\\atguiguTest.xlsx";
        EasyExcel.write(fileName, User.class).sheet("写操作").doWrite(data());
    }

    private static List<User> data(){
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setNumber(i);
            user.setName("用户"+i);
            list.add(user);
        }
        return list;
    }
}
