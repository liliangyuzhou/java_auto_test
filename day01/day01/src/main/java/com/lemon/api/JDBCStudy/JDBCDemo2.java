package com.lemon.api.JDBCStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo2 {

    public static void main(String[] args){

        query();


    }

    public static void query(){
        //?代表占位符
        String sql="select leaveamount from member where mobilephone=?";
        //如果sql是完整的，没有用到占位符，那么后面的设置条件字段的值这一步就不用写了
        //eg:select leaveamount from member where mobilephone='15511447879',这样的sql就不用
        //调用preparedStatement.setObject去设置sql条件字段的值了

        //根据连接信息获取数据库连接（连上数据库）

        try {

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
            preparedStatement.setObject(1,"15511447879");
            //调用查询方法，执行查询，返回ResultSet（结果集）
            ResultSet resultSet=preparedStatement.executeQuery();
            //从结果集中查询数据,因为可能查询出来多条数据，所以要通过遍历
            //判断结果集里面是否有数据resultSet.next()，为true则进行while循环
            while(resultSet.next()){
                // 从结果集中取出查询字段的值，并转换为字符转
                String leaveamount=resultSet.getObject("leaveamount").toString();
                System.out.println(leaveamount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


