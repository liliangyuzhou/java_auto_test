package com.lemon.api.auto8.pojo;


/**
 * 保存Case的信息
 */
public class Case {
    private String caseId;
    private  String apiId;
    private  String desc;
    private  String params;
    private String expectedResponseData;
    private String actualResponseData;

    private  String preValidateSql;
    private String preValidateResult;

    public String getPreValidateSql() {
        return preValidateSql;
    }

    public void setPreValidateSql(String preValidateSql) {
        this.preValidateSql = preValidateSql;
    }

    public String getPreValidateResult() {
        return preValidateResult;
    }

    public void setPreValidateResult(String preValidateResult) {
        this.preValidateResult = preValidateResult;
    }

    public String getAfterValidateSql() {
        return afterValidateSql;
    }

    public void setAfterValidateSql(String afterValidateSql) {
        this.afterValidateSql = afterValidateSql;
    }

    public String getAfterValidateResult() {
        return afterValidateResult;
    }

    public void setAfterValidateResult(String afterValidateResult) {
        this.afterValidateResult = afterValidateResult;
    }

    private String afterValidateSql;
    private  String afterValidateResult;


    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    public String getExpectedResponseData() {
        return expectedResponseData;
    }

    public void setExpectedResponseData(String expectedResponseData) {
        this.expectedResponseData = expectedResponseData;
    }

    public String getActualResponseData() {
        return actualResponseData;
    }

    public void setActualResponseData(String actualResponseData) {
        this.actualResponseData = actualResponseData;
    }


    @Override
    public String toString() {
        return "caseId="+caseId+",apiId="+apiId+",desc="+desc+",params="+params+",expectedResponseData="+expectedResponseData+",actualResponseData="+actualResponseData+",preValidateSql="+preValidateSql+",preValidateResult"+preValidateResult+",aftervalidateSql"+afterValidateSql+",aftervalidateResult"+afterValidateResult;
    }
}
