package com.lemon.api.auto2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterTestCase_v4 {

    @Test(dataProvider = "datasource")
    public void test1(String mobliephone,String pwd){

        String url="http://test.lemonban.com/futureloan/mvc/api/member/register";
        Map<String,String> params= new HashMap<String, String>();
        params.put("mobilephone",mobliephone);
        params.put("pwd",pwd);

        String result=HttpUtil.doGet(url,params);
        System.out.println(result);
    }

    //testng里面的数据提供者,一般不写name属性的话，在测试用例中使用数据提供者是，name默认为数据提供者的方法名
    @DataProvider(name="datasource")
    public Object[][] datas(){

        int [] rows={2,3,4,5,6,8};
        int [] cells={6,7};

        Object[][] datas=ExcelUtil.datas("/Users/liliang/IdeaProjects/day01/src/main/resources/testcase_V1.xlsx",rows,cells);

        return datas;

    }

}
