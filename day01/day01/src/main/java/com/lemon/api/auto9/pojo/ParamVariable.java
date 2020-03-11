package com.lemon.api.auto9.pojo;

public class ParamVariable {
    private String name;
    private String value;
    private  String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




    @Override
    public String toString() {
        return "name"+this.name+",value="+this.value+",remarks="+remarks;
    }
}
