package com.leslie.springcloud_demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T object;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
