package com.lemon.api.auto2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class PostDemo {
    public static void main(String[] args) throws IOException {
        String url="http://test.lemonban.com/futureloan/mvc/api/member/register";
        Map<String,String> params= new HashMap<String, String>();
        params.put("mobilephone","15710000100");
        params.put("pwd","123456");
        System.out.println(params);
//        {mobilephone=15710000100, pwd=123456}

        String result=HttpUtil.doPost(url,params);
        System.out.println(result);

    }

}
