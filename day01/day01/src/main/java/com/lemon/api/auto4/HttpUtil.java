package com.lemon.api.auto4;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {


    //以post方式调用接口的工具方法
    public static String doPost(String url, Map<String,String> params) {


        //2.接口的请求方式
        HttpPost post=new HttpPost(url);


        //3.准备测试数据


        List<BasicNameValuePair> param =new ArrayList<BasicNameValuePair>();
        Set<String> keys=params.keySet();
        for (String paramkey:keys) {
            String paramvalue=params.get(paramkey);
            param.add(new BasicNameValuePair(paramkey,paramvalue));

        }
        String result="";

        try {
            post.setEntity(new UrlEncodedFormEntity(param, "utf-8"));
            //4.准备请求头数据（如有必要，比如cookie，content-type等）

            //5.发起请求，获取接口响应信息（状态码，响应报文，或者某些特殊的响应头数据）
            HttpClient client = HttpClients.createDefault();
            HttpResponse response = client.execute(post);


            //获取状态码
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code);
            //获取响应结果
            result = EntityUtils.toString(response.getEntity());
        }catch(Exception e){

            e.printStackTrace();

        }
        return result;
    }


    //以get方式调用接口的工具方法
    public static String doGet(String url, Map<String,String> params){
        Set<String> keys=params.keySet();
        int mark=1;
        for (String paramkey:keys) {

            String paramvalue = params.get(paramkey);
            if (mark==1){
                url+=("?"+paramkey+"="+paramvalue);
            }else {
                url+=("&"+paramkey+"="+paramvalue);

            }
            mark++;
        }
        System.out.println(url);

        //2.获取接口的请求方式
        HttpGet get=new HttpGet(url);
        String result="";
        try {

            CloseableHttpClient client = HttpClients.createDefault();

          HttpResponse HttpResponse = client.execute(get);

            //4.准备接口的请求头信息，如果有必要的话


            //5.获取接口的状态码，响应结果等。

            System.out.println(HttpResponse.getStatusLine().getStatusCode());
            result = EntityUtils.toString(HttpResponse.getEntity());
        }catch(Exception e){
            e.printStackTrace();
        }


        return result;

    }


    /** 根据判断type来确认接口请求的方式
     * @param type 接口请求的方式
     * @param url 接口的请求地址
     * @param params 接口请求的参数
     * @return
     */
    public static String doService(String type,String url,Map<String,String> params){
        String result=null;
        if (type.equalsIgnoreCase("post")){

            result= HttpUtil.doPost(url,params);
        }else if(type.equalsIgnoreCase("get")){

            result= HttpUtil.doGet(url,params);
        }
        return result;
    }

}
