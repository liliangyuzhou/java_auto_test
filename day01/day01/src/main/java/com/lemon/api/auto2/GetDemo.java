package com.lemon.api.auto2;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetDemo {
    public static void main(String[] args) throws IOException {
        //1.获取接口的请求地址
        String url="http://test.lemonban.com/futureloan/mvc/api/member/register";
        Map<String,String> params= new HashMap<String, String>();
        params.put("mobilephone","15711000100");
        params.put("pwd","123456");

        String result=HttpUtil.doGet(url,params);
        System.out.println(result);





    }

}
