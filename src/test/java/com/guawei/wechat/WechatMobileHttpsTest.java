package com.guawei.wechat;

import com.alibaba.fastjson.JSONObject;
import com.guanwei.wechat.utils.AesTool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @Author Ang
 * @Date 2020/7/31 21:34
 */
@SpringBootTest
public class WechatMobileHttpsTest {

    private String key = "MetLife&VHS.2020";


    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("application/json; charset=utf-8");
    @Test
    public void testReceiveVhsOrderInfo1() throws IOException {
        Request request = new Request.Builder()
                .url("https://vtest.valurise.com/client/apt/index.html?flowId=CWB27Y&custId=abc")
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
        }
    }

    @Test
    public void test02(){
        String data = "{\"flowId\":\""+124+"\"";
        System.out.println(data);
    }

    @Test
    public void testBaidu() throws IOException{
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
        }
    }


    @Test
    public void testHrsUel() throws  IOException{
        String jsonObj = "{\"gender\":\"1\",\"hisServiceCode\":\"HRS-32\",\"policyNumber\":\"01295828\",\"certTypeCode\":\"3\",\"customerName\":\"程度比\",\"productName\":\"健康随心(AGY)\",\"proPackageCode\":\"0D0E1050-4F6D-4985-BF0F-6DBBB8CE4E5B\",\"productCode\":\"ED29AA\",\"hisServiceName\":\"电话医生\",\"statusMsg\":\"\",\"rpadFourth\":\"7532\",\"customerId\":\"01016161\",\"proPackageName\":\"健康随心(AGY)-ED29AA-经典\",\"customerRole\":\"01\",\"statusCode\":\"\"}";
        System.out.println(jsonObj);
        JSONObject jsonObject = JSONObject.parseObject(jsonObj);
        //String encryptStr = AesTool.encrypt(jsonObject.toString(), key);
        Request request = new Request.Builder()
                .url("http://localhost:8080/wechatmobile/getHRSUrl")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, jsonObject.toString()))
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
        }
    }

    @Test
    public void testStringJoin(){
        String join = String.join(":", new String[]{"a", "b", "c"});
        System.out.println(join);

    }

    /**
     * case8: 图文问诊申请
     * @throws IOException
     */
    @Test
    public void testReceiveVhsOrderInfo8() throws IOException {
        //15650456405

        /*"    \"serviceStatus\":\"已完成\",\n" +
                "    \"serviceStatusCode\":\"03\",\n" +
                "    \"passServiceCode\":\"A419393F-2A4E-41D3-888C-1DE0B5E97C1A\",\n" +
                "    \"skip\":\"0\",\n" + */

        String paramJson = "{\n" +
                "    \"customerId\":\"01015558\",\n" +
                "    \"customerName\":\"十大十大\",\n" +
                "    \"customerRole\":\"01\",\n" +
                "    \"idCard\":\"123456789012345678\",\n" +
                "    \"idType\":\"身份证\",\n" +
                "    \"packageCode\":\"C35F792B-D452-43E9-9829-E0A99BCF60E1\",\n" +
                "    \"packageName\":\"健康随心终身(AGY)-WL07AA-白金\",\n" +
                "    \"passServiceCode\":\"654FA441-5856-4A9D-BAD3-31F052F835FE\",\n" +
                "    \"policyNo\":\"01295438\",\n" +
                "    \"productCode\":\"WL07AA\",\n" +
                "    \"productName\":\"健康随心终身(AGY)\",\n" +
                "    \"relativeBirthday\":\"1980-01-01\",\n" +
                "    \"relativeName\":\"李白\",\n" +
                "    \"relativeTypeCode\":\"02\",\n" +
                "    \"reserveDate\":\"2020-08-26 14:58:03\",\n" +
                "    \"serviceCode\":\"HRS-03\",\n" +
                "    \"serviceDate\":\"2020-08-26 14:58:03\",\n" +
                "    \"serviceName\":\"导医服务（不限疾病）\",\n" +
                "    \"serviceOrderId\":\"3CHN36\",\n" +
                "    \"serviceStatus\":\"已申请\",\n" +
                "    \"serviceStatusCode\":\"01\",\n" +
                "    \"skip\":0,\n" +
                "    \"tel\":\"18073703194\"\n" +
                "}";

        paramJson = paramJson.replaceAll("_", "");
        String encryptStr = AesTool.encrypt(paramJson, key);

        Request request = new Request.Builder()
                .url("http://localhost:8080/wechatmobile/receiveVhsOrderInfo")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, encryptStr))
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            System.out.println(AesTool.decrypt(response.body().string(), "MetLife&VHS.2020"));
        }
    }

    /**
     * case: 提供好人生查询次数接口
     * @throws IOException
     */
    @Test
    public void testgetServiceCount() throws IOException {
        String paramJson = "{\n" +
                "  \"serviceNumber\" : \"0\",\n" +
                "  \"idType\" : \"身份证\",\n" +
                "  \"serviceCode\" : \"HRS-20\",\n" +
                "  \"idCard\" : \"123456789123455789\",\n" +
                "  \"policyNo\" : \"01295827\",\n" +
                "  \"skip\" : \"0\",\n" +
                "  \"serviceName\" : \"手术预约（限指定疾病）\",\n" +
                "  \"customerName\" : \"反倒吖\",\n" +
                "  \"productName\" : \"健康随心(AGY)\",\n" +
                "  \"relativeName\" : \"\",\n" +
                "  \"relatedServiceOrderId\" : \"AKQ9KS\",\n" +
                "  \"productCode\" : \"ED29AA\",\n" +
                "  \"passServiceCode\" : \"\",\n" +
                "  \"relativeBirthday\" : \"\",\n" +
                "  \"packageCode\" : \"0D0E1050-4F6D-4985-BF0F-6DBBB8CE4E5B\",\n" +
                "  \"residueNumber\" : \"0\",\n" +
                "  \"relativeTypeCode\" : \"\",\n" +
                "  \"customerId\" : \"01016159\",\n" +
                "  \"tel\" : \"17634382222\",\n" +
                "  \"packageName\" : \"健康随心(AGY)-ED29AA-经典\",\n" +
                "  \"relativeTypeName\" : \"\",\n" +
                "  \"customerRole\" : \"01\",\n" +
                "  \"serviceOrderId\" : \"FD17GS\"\n" +
                "}";
        paramJson = paramJson.replaceAll("_", "");
        String encryptStr = AesTool.encrypt(paramJson, key);
        System.out.println(encryptStr);
        Request request = new Request.Builder()
                .url("http://localhost:8080/wechatmobile/getServiceCount")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, encryptStr))
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            System.out.println(AesTool.decrypt(response.body().string(), "MetLife&VHS.2020"));
        }
    }


    public static void main(String[] args) {
        /*String abc = "123";
        String data = "{\"flowId\":\""+abc+"\"}";
        System.out.println(data);

        String jsonstr = "{\"studentName\":\"lily\",\"studentAge\":12}";
        System.out.println(jsonstr);*/

        Integer str = null;
        System.out.println(str.toString());
    }
}
