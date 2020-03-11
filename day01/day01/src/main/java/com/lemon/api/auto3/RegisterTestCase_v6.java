package com.lemon.api.auto3;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterTestCase_v6 {

    @Test(dataProvider = "datasource")
    public void test1(String apiIdFromCase,String parameter){

        String url="";
        String type="";
        int[] rows={2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] cells={1,3,4};
        Object [][] datas=ExcelUtil.datas("/Users/liliang/IdeaProjects/day01/src/main/resources/testcase_V3.xlsx","接口信息",rows,cells);

        for (Object[] objects:datas) {
            String apiIdfromExcelInfo=objects[0].toString();
            if(apiIdFromCase.equals(apiIdfromExcelInfo)) {
                type=objects[1].toString();
                url = objects[2].toString();
                break;

            }

        }


        Map<String,String> params= (Map<String, String>) JSONObject.parse(parameter);
        String result=judgeRequestType(url, type, params);
        System.out.println(result);
    }

    private String judgeRequestType(String url, String type, Map<String, String> params) {
        String result="";
        if (type.equalsIgnoreCase("post")){

        result= HttpUtil.doGet(url,params);
        }else{

         result=HttpUtil.doGet(url,params);
        }
        return result;

    }

    //testng里面的数据提供者,一般不写name属性的话，在测试用例中使用数据提供者是，name默认为数据提供者的方法名
    @DataProvider(name="datasource")
    public Object[][] datas(){

        int [] rows={2,3,4,5,6};
        int [] cells={3,4};

        Object[][] datas= ExcelUtil.datas("/Users/liliang/IdeaProjects/day01/src/main/resources/testcase_V3.xlsx","register",rows,cells);

        return datas;

    }
    public static void main(String[] args){

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
