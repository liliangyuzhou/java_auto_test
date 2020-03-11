package com.lemon.api.auto7.TestCases;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto7.Util.AssertUtil;
import com.lemon.api.auto7.Util.ExcelUtil;
import com.lemon.api.auto7.Util.HttpUtil;
import com.lemon.api.auto7.Util.RestUtil;
import com.lemon.api.auto7.pojo.WriteBackData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 接口测试统一处理类
 */
public class BaseProcessor {
    @Test(dataProvider = "datasource")
    public void test1(String caseId,String apiId,String parameter,String expectedResponseData){

        //json字符串可以直接通过json解析，放到Map中
        Map<String,String> params= (Map<String, String>) JSONObject.parse(parameter);
        //URL获取
        String url= RestUtil.getUrlByApiId(apiId);
//        System.out.println(url);
        //type获取
        String type= RestUtil.getTypeByApiId(apiId);

        String actualResponseData= HttpUtil.doService(type,url, params);
        System.out.println(actualResponseData);

        //下面用actualResponseData接收断言的返回值，因为这个字段本来就是被回写的字段，这里没有回写到另外的字段中
        actualResponseData= AssertUtil.assertEquals(expectedResponseData,actualResponseData);

        //在这里直接回写会造成很多excel的读写开销
        //ExcelUtil.writeBackData("src/main/resources/testcase_V5.xlsx","register",caseId,"ActualResponseData",result);

        //将要回写的数据对象封装到集合中
        WriteBackData writebackdata=new WriteBackData("register",caseId,"ActualResponseData",actualResponseData);
        ExcelUtil.writeBackDatas.add(writebackdata);
    }

    //测试套件执行完毕后，批量回写数据到excel中
    @AfterSuite
    public void batchWriteBackDatas(){

        ExcelUtil.batchWriteBackDatas("src/main/resources/testcase_V6.xlsx");

    }

}
