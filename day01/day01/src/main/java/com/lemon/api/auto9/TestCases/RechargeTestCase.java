package com.lemon.api.auto9.TestCases;

import com.lemon.api.auto9.Util.CaseUtil;
import org.testng.annotations.DataProvider;

public class RechargeTestCase extends BaseProcessor {

    @DataProvider(name="datasource")
    public Object[][] datas(){

        Object[][] datas= CaseUtil.getCaseDatasByApiId("3",cellNames);
        return datas;

    }
}
