package com.lemon.api.auto5;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 接口测试统一处理类
 */
public class BaseProcessor {
    @Test(dataProvider = "datasource")
    public void test1(String caseId,String apiId,String parameter){

        //json字符串可以直接通过json解析，放到Map中
        Map<String,String> params= (Map<String, String>) JSONObject.parse(parameter);
        //URL获取
        String url= RestUtil.getUrlByApiId(apiId);
//        System.out.println(url);
        //type获取
        String type= RestUtil.getTypeByApiId(apiId);

        String result= HttpUtil.doService(type,url, params);
        System.out.println(result);

        //在这里直接回写会造成很多excel的读写开销
        //ExcelUtil.writeBackData("src/main/resources/testcase_V5.xlsx","register",caseId,"ActualResponseData",result);

        //将要回写的数据对象封装到集合中
        WriteBackData writebackdata=new WriteBackData("register",caseId,"ActualResponseData",result);
        ExcelUtil.writeBackDatas.add(writebackdata);
    }

    //测试套件执行完毕后，批量回写数据到excel中
    @AfterSuite
    public void batchWriteBackDatas(){

        ExcelUtil.batchWriteBackDatas("src/main/resources/testcase_V5.xlsx");

    }

}
