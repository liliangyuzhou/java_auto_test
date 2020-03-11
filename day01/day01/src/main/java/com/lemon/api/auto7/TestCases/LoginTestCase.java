package com.lemon.api.auto7.TestCases;

import com.lemon.api.auto7.Util.CaseUtil;
import org.testng.annotations.DataProvider;

/**
 * 登陆接口测试类
 */
public class LoginTestCase extends BaseProcessor {


    //testng里面的数据提供者,一般不写name属性的话，在测试用例中使用数据提供者是，name默认为数据提供者的方法名
    @DataProvider(name="datasource")
    public Object[][] datas(){

        String [] cellNames ={"CaseId","ApiId","Params","ExpectedResponseData"};

        Object[][] datas= CaseUtil.getCaseDatasByApiId("2",cellNames);
        return datas;

    }
}
