package com.lemon.api.auto9.Util;

import com.lemon.api.auto9.pojo.ParamVariable;
import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.*;

/**
 *参数化工具类
 */
public class VariableUtil {

    public static Map<String,String> VariableNamesAndValuesMap=new HashMap<String, String>();

    public static List<ParamVariable> paramVariableList=new ArrayList<ParamVariable>();

    static{
        //1.加载表单里面的每一行数据，封装成一个ParemVariable对象，然后统一放到集合中
//        List<ParamVariable> list=ExcelUtil.load("src/main/resources/testcase_V8.xlsx","paramVariable",ParamVariable.class);
        List<ParamVariable> list=ExcelUtil.load(PropertiesUtil.getExcelPath(),"paramVariable",ParamVariable.class);

        paramVariableList.addAll(list);
        //将行对象里面的key和value放到map中
        loadVariablesToMap();
    }
    /**替换参数里面的变量
     * @param parameter
     * @return
     */
    public static String replaceVariable(String parameter) {

        Set<String> paramVariableNames=VariableNamesAndValuesMap.keySet();
        for (String paramVariableName:paramVariableNames) {
            if(parameter.contains(paramVariableName)){
                parameter=parameter.replace(paramVariableName, VariableNamesAndValuesMap.get(paramVariableName));
                System.out.println(parameter);
            }

        }


        return parameter;
    }

    /**
     *  遍历对应集合，将key和对应的value保存到map中
     */
    private static void loadVariablesToMap() {
        for (ParamVariable paramVariable:paramVariableList) {
            String paramVariableName=paramVariable.getName();
            String paramVariableValue=paramVariable.getValue();
            VariableNamesAndValuesMap.put(paramVariableName,paramVariableValue);

        }
    }
}
