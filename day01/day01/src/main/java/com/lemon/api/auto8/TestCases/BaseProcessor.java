package com.lemon.api.auto8.TestCases;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto8.Util.*;
import com.lemon.api.auto8.pojo.WriteBackData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 接口测试统一处理类
 */
public class BaseProcessor {


    String [] cellNames ={"CaseId","ApiId","Params","ExpectedResponseData","PreValidateSql","AfterValidateSql"};


    @Test(dataProvider = "datasource")
    public void test1(String caseId,String apiId,String parameter,String expectedResponseData,String prevalidateSql,String aftervalidateSql ){
        if(prevalidateSql !=null && prevalidateSql.trim().length()>0){
            //在接口调用前执行sql查询我们需要验证的字段
            String preValidateResult= DBCheckUtil.doQuery(prevalidateSql);

            WriteBackData writebackdata=new WriteBackData("register",caseId,"PreValidateResult",preValidateResult);
            ExcelUtil.writeBackDatas.add(writebackdata);


        }
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

        if(aftervalidateSql !=null && aftervalidateSql.trim().length()>0){
            //在接口调用后执行sql查询我们需要验证的字段
            String afterValidateResult= DBCheckUtil.doQuery(aftervalidateSql);

            ExcelUtil.writeBackDatas.add(new WriteBackData("register",caseId,"AfterValidateResult",afterValidateResult));

        }
    }

    //测试套件执行完毕后，批量回写数据到excel中
    @AfterSuite
    public void batchWriteBackDatas(){

        ExcelUtil.batchWriteBackDatas("src/main/resources/testcase_V7.xlsx");

    }

}
