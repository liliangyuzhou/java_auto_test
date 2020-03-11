package com.lemon.api.auto3;

public class RegisterParam {
    private String mobilephone;
    private String pwd;


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobliephone() {
        return mobilephone;
    }

    public void setMobliephone(String mobliephone) {
        this.mobilephone = mobliephone;
    }

    @Override
    public String toString() {
        return "mobilephone="+mobilephone+"pwd="+pwd;
    }
}
