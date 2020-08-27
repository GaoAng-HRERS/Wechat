package com.guanwei.wechat.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Author Ang
 * @Date 2020/8/21 12:51
 */
@Data
public class User {

    public String username="";
    public int id=0;
    public ArrayList<Link> link=null;
    public Map<String,Link> result=null;
}
