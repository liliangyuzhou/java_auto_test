package com.lemon.api.auto8.Util;

import com.lemon.api.auto8.pojo.Rest;

import java.util.ArrayList;
import java.util.List;

public class RestUtil {

    public static List<Rest> rests=new ArrayList<Rest>();
    static{
        ExcelUtil.load("src/main/resources/testcase_V7.xlsx","接口信息", Rest.class);

    }

    /**通过apiId获取接口的url
     * @param apiId 接口编号
     * @return
     */

    public static String getUrlByApiId(String apiId) {
        for (Rest rest:rests) {
            if (rest.getApiId().equals(apiId)){
                return rest.getUrl();

            }
        }
        return  "";
    }

    /**通过apiId获取接口的type
     * @param apiId 接口编号
     * @return
     */

    public static String getTypeByApiId(String apiId) {

        for (Rest rest:rests) {
            if (rest.getApiId().equals(apiId)){
                return rest.getType();

            }
        }
        return  "";

    }

    public static void main(String[] args){

//        for (Rest rest:rests) {
//            System.out.println(rest);
//
//
//        }
        System.out.println(getTypeByApiId("1"));
        System.out.println(getUrlByApiId("1"));


    }
}
