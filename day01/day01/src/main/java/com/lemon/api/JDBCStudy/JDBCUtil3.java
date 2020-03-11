package com.lemon.api.JDBCStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JDBCUtil3 {

    public static void main(String[] args){
//传values调用实例
//        String sql="select leaveamount from member where mobilephone=?";
//        Object [] values={"15511447879"};
//        query(sql,values);

        //不传values调用实例
//        String sql="select leaveamount from member where mobilephone=15511447879";
        String sql="select id,leaveamount from member where mobilephone=15511447879";

        Map<String,Object> map=query(sql);
        Set<String> keys=map.keySet();
        for (String key:keys) {
           Object value=map.get(key);
           System.out.println(key+"="+value);

        }



    }

    /**多传一个values可变参数，可以根据where条件是否有占位符？传入对应where条件字段的值，多个放在数组中
     * 但还是要优化，因为这里只能取单条sql查询的固定字段，如果sql的想查询字段变化就不能调用这个方法了。
     * @param sql
     * @param values
     */
    public static Map<String,Object> query(String sql,Object ... values){
        //?代表占位符

        //如果sql是完整的，没有用到占位符，那么后面的设置条件字段的值这一步就不用写了
        //eg:select leaveamount from member where mobilephone='15511447879',这样的sql就不用
        //调用preparedStatement.setObject去设置sql条件字段的值了
        Map<String,Object> columnLabelAndValues=null;
        try {

        //根据连接信息获取数据库连接（连上数据库）
            Properties properties =new Properties();
            InputStream inputStream =new FileInputStream(new File("src/main/resources/jdbc.properties"));
            properties.load(inputStream);
            String url=properties.getProperty("jdbc.url");
            String user=properties.getProperty("jdbc.user");
            String password=properties.getProperty("jdbc.password");
            Connection connection= DriverManager.getConnection(url,user,password);
            System.out.println("连接数据库成功");
            //根据连接获取prepareStatement对象（此类型的对象提供操作数据库的操作方法）
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            //设置条件字段的值，如果有多个字段就多次setObject方法即可
            for (int i = 0; i <values.length ; i++) {
            preparedStatement.setObject(i+1,values[i]);

            }
            //调用查询方法，执行查询，返回ResultSet（结果集）
            ResultSet resultSet=preparedStatement.executeQuery();
            //从结果集中查询数据,因为可能查询出来多条数据，所以要通过遍历
            //判断结果集里面是否有数据resultSet.next()，为true则进行while循环

            //获取查询sql的相关信息
            ResultSetMetaData metaData=resultSet.getMetaData();

            //获取sql中查询字段的个数
            int columnCount=metaData.getColumnCount();
            columnLabelAndValues=new HashMap<String, Object>();
            while(resultSet.next()){
                // 从结果集中取出查询字段的值，并转换为字符转
                for (int i = 1; i <=columnCount ; i++) {
                    String columnLabel=metaData.getColumnLabel(i);
                    String columnValue=resultSet.getObject(columnLabel).toString();
//                    System.out.println(columnValue);
                    columnLabelAndValues.put(columnLabel,columnValue);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnLabelAndValues;
    }
}


