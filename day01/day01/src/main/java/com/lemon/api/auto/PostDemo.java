package com.lemon.api.auto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostDemo {
    public static void main(String[] args) throws IOException {

        //1.填写接口的请求地址

        String preurl="http://test.lemonban.com/futureloan/mvc/api/member/register";

        //2.接口的请求方式
        HttpPost post=new HttpPost(preurl);


        //3.准备测试数据
        String mobilephone="15811457878";
        String pwd ="123456";
        List<BasicNameValuePair> param =new ArrayList<BasicNameValuePair>();
        param.add(new BasicNameValuePair("mobilephone",mobilephone));
        param.add(new BasicNameValuePair("pwd",pwd));

        post.setEntity(new UrlEncodedFormEntity(param,"utf-8"));


        //4.准备请求头数据（如有必要，比如cookie，content-type等）

        //5.发起请求，获取接口响应信息（状态码，响应报文，或者某些特殊的响应头数据）
        HttpClient client= HttpClients.createDefault();
        HttpResponse response=client.execute(post);


        System.out.println(response.getStatusLine());
        System.out.println(response.getEntity());
        //获取状态码
        int code=response.getStatusLine().getStatusCode();
        System.out.println(code);
        //获取响应结果
        String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);




    }


}
