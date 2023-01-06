package com.atguigu.ggkt.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgktException extends RuntimeException{
    private Integer code;
    private String message;
}
