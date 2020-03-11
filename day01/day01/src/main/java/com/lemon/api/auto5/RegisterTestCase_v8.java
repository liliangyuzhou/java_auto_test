package com.lemon.api.auto5;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto3.RegisterParam;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

//相比于RegisterTestCase_v7，增加断言
public class RegisterTestCase_v8 {

    @Test(dataProvider = "datasource")
    public void test1(String apiId,String parameter,String ExpectedResponseData){

        //json字符串可以直接通过json解析，放到Map中
        Map<String,String> params= (Map<String, String>) JSONObject.parse(parameter);
        //URL获取
        String url= RestUtil.getUrlByApiId(apiId);
//        System.out.println(url);
        //type获取
        String type= RestUtil.getTypeByApiId(apiId);

        String result= HttpUtil.doService(type,url, params);
//        System.out.println(result);
        Assert.assertEquals(result,ExpectedResponseData);
    }


    //testng里面的数据提供者,一般不写name属性的话，在测试用例中使用数据提供者是，name默认为数据提供者的方法名
    @DataProvider(name="datasource")
    public Object[][] datas(){

        String [] cellNames ={"ApiId","Params","ExpectedResponseData"};

        Object[][] datas= CaseUtil.getCaseDatasByApiId("1",cellNames);
        return datas;

    }

    public static void main(String[] args){

//json解析
//        String paramter="{\"status\":\"0\",\"code\":\"20103\",\"data\":null,\"msg\":\"密码不能为空\"}";
//        Map<String,String> params= (Map<String, String>) JSONObject.parse(paramter);
//        Set<String> keys=params.keySet();
//        for (String key:keys) {
//            String value=params.get(key);
//
//            System.out.println("key="+key+",value="+value);
//
//        }
        String parameters="{\"mobilephone\": \"15810447878\", \"pwd\": \"\"}";
        RegisterParam registerParam=JSONObject.parseObject(parameters,RegisterParam.class);
        System.out.println(registerParam);


    }

}
