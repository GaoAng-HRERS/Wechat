package com.guawei.wechat.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.guanwei.wechat.entity.DataJson;
import com.guanwei.wechat.entity.Link;
import com.guanwei.wechat.entity.Result;
import com.guanwei.wechat.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ang
 * @Date 2020/8/21 10:35
 */
public class JsonTest {


    public static void testJson(){
        String jsonStr = "{\n" +
                "  \"a\":\"1\",\n" +
                "  \"b\":\"2\",\n" +
                "  \"c\":\"3\",\n" +
                "  \"list\":[{\"d\":\"4\",\"e\":\"5\"},{\"d\":\"4\",\"e\":\"5\"},{\"d\":\"4\",\"e\":\"5\"}]\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        List<Result> data = JSON.parseObject(jsonArray.toJSONString(), new TypeReference<List<Result>>() {
        });
       data.forEach((d)->{
            System.out.print("a"+d.getD()+"\n");
        });
        DataJson dataJson = JSON.parseObject(jsonStr, DataJson.class);
        dataJson.getList().forEach((d) -> {
            System.out.print("a"+d.getE()+"\n");
        });
    }

    public static void testJsonToObject(){
        String str = "{\n" +
                "\"time\":\"2020-02-02\",\n" +
                "\"b\":\"2\",\n" +
                "\"c\":\"\",\n" +
                "\"obj\":{\"d\":\"12\",\"e\":\"Json\"},\n" +
                "  \"list\":[{\"d\":\"4\",\"e\":\"5\"},{\"d\":\"4\",\"e\":\"5\"},{\"d\":\"4\",\"e\":\"5\"}]\n" +
                "}";
        JSONObject json = JSONObject.parseObject(str);
        DataJson dataJson = JSON.parseObject(str, new TypeReference<DataJson>() {});
        DataJson object = JSONObject.toJavaObject(json, DataJson.class);
        System.out.println(object.getTime());

    }
    public static void setUser(User user){
        user.setId(1);
        user.setUsername("xiaoxiang");
        Link lk=new Link();
        lk.setName("rongrong");
        lk.setPhone("1234234");
        Link lk1=new Link();
        lk1.setName("rongrong");
        lk1.setPhone("1234234");
        ArrayList<Link> list=new ArrayList();
        list.add(lk1);
        list.add(lk);
        user.setLink(list);
        Map map=new HashMap();
        map.put("123",lk);
        map.put("234",lk1);
        user.setResult(map);
    }

    public static void main(String[] args) {
//        User user=new User();
//        setUser(user);
//        //将javabean转成json
//        String str= JSON.toJSONString(user);
//        System.out.println("fastJson"+str);
//        //将json转成java bean
//        User myuser=JSON.parseObject(str,User.class);
//        System.out.println(myuser.getResult().get("123").getName());
        //testJson();

        testJsonToObject();
    }
}
