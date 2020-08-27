package com.guanwei.wechat.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author Ang
 * @Date 2020/8/21 12:58
 */
@Data
public class DataJson {
    private LocalDate time;
    private String b;
    private String c;
    private List<Result> list;
    private Result obj;
}
