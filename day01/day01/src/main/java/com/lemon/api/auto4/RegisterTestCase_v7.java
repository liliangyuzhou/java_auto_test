package com.lemon.api.auto4;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto3.RegisterParam;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

//相比于RegisterTestCase_v6
//这个测试用例中使用反射封装了excel里面的测试用例对象。使用反射调用了Case类的set方法，
// 在编写数据提供者的时候，使用反射封装了二维数组datas。使用反射调用了Case类的get方法
//使用反射解决了强耦合，是代码不局限于本次设计的excel用例的字段名。使代码变得更容易维护。

//使用反射调用反射类中的方法，不需要局限于类里面的属性的和方法（这里意思是，以后代码做了改变，比如加了一个属性和
//set，get方法。不需要再次修改代码。因为在使用到反射调用的时候，都是for循环遍历调用所有的set，get方法。所以说
//反射真的非常好用。可以使代码变得更加容易维护。
public class RegisterTestCase_v7 {

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
