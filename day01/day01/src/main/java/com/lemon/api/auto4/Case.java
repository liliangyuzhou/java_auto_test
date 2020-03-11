package com.lemon.api.auto4;


/**
 * 保存Case的信息
 */
public class Case {
    private String caseId;
    private  String apiId;
    private  String desc;
    private  String params;



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

    @Override
    public String toString() {
        return "caseId="+caseId+",apiId="+apiId+",desc="+desc+",params="+params;
    }
}
