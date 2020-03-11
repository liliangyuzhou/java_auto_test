package com.lemon.api.auto;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetDemo {
    public static void main(String[] args) throws IOException {
        //1.获取接口的请求地址
        String preurl="http://test.lemonban.com/futureloan/mvc/api/member/register";




        //3.准备接口的请求参数
        String mobilephone="15821457878";
        String pwd ="123456";


        preurl+=("?mobilephone="+mobilephone+"&"+"pwd="+pwd);

        //2.获取接口的请求方式
        HttpGet get=new HttpGet(preurl);

        CloseableHttpClient client=HttpClients.createDefault();

        CloseableHttpResponse closeableHttpResponse=client.execute(get);

        //4.准备接口的请求头信息，如果有必要的话


        //5.获取接口的状态码，响应结果等。

        System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
        String result= EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println(result);




    }
}
