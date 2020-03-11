package com.lemon.api.auto6;

import org.testng.annotations.DataProvider;

public class RechargeTestCase extends BaseProcessor {

    @DataProvider(name="datasource")
    public Object[][] datas(){

        String [] cellNames ={"CaseId","ApiId","Params"};

        Object[][] datas= CaseUtil.getCaseDatasByApiId("3",cellNames);
        return datas;

    }
}
