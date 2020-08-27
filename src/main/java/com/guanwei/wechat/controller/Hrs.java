package com.guanwei.wechat.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @Author Ang
 * @Date 2020/7/31 22:44
 */
@Controller
public class Hrs {

    @GetMapping(value = "/hrs")
    public String login() throws IOException{
        Request request = new Request.Builder()
                .url("https://vtest.valurise.com/client/apt/index.html?flowId=CWB27Y&custId=abc")
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
        }
        return "index";

    }
}
