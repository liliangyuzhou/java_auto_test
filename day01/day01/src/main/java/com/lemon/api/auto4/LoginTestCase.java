package com.lemon.api.auto4;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 登陆接口测试类
 */
public class LoginTestCase {

    @Test(dataProvider = "datasource")
    public void test1(String apiId,String parameter){

        //json字符串可以直接通过json解析，放到Map中
        Map<String,String> params= (Map<String, String>) JSONObject.parse(parameter);
        //URL获取
        String url=RestUtil.getUrlByApiId(apiId);
//        System.out.println(url);
        //type获取
        String type=RestUtil.getTypeByApiId(apiId);

        String result=HttpUtil.doService(type,url, params);
        System.out.println(result);
    }


    //testng里面的数据提供者,一般不写name属性的话，在测试用例中使用数据提供者是，name默认为数据提供者的方法名
    @DataProvider(name="datasource")
    public Object[][] datas(){

        String [] cellNames ={"ApiId","Params"};

        Object[][] datas= CaseUtil.getCaseDatasByApiId("2",cellNames);
        return datas;

    }
}
