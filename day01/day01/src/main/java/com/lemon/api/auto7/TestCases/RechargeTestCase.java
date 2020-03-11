package com.lemon.api.auto7.TestCases;

import com.lemon.api.auto7.Util.CaseUtil;
import org.testng.annotations.DataProvider;

public class RechargeTestCase extends BaseProcessor {

    @DataProvider(name="datasource")
    public Object[][] datas(){

        String [] cellNames ={"CaseId","ApiId","Params","ExpectedResponseData"};

        Object[][] datas= CaseUtil.getCaseDatasByApiId("3",cellNames);
        return datas;

    }
}
