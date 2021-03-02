package com.haiziwang.commodity.jdbc;

import com.haiziwang.commodity.mapper.ConversionSpuMapper;
import com.haiziwang.commodity.model.po.ConversionSpuPO;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class JDBC {
    //数据库url、用户名和密码
//    static final String DB_URL = "jdbc:mysql://172.172.178.18:3309/commodity_spu?characterEncoding=UTF-8&serverTimezone=GMT%2B8&zeroDateTimeBehavior=convertToNull";
//    static final String USER = "commodityspu";
//    static final String PASS = "commodityspu";
//
//    public static void main(String[] args) {
//        PerformanceUtil per = new PerformanceUtil();
//        try {
//            //1、注册JDBC驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //2、获取数据库连接
//            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            //3、操作数据库
//            Statement statement = connection.createStatement();//获取操作数据库的对象
//            String sql = "SELECT Fspuid,Fspuonlinetitle,Fspuaddtime,Fsputitle FROM t_spu_0 where Fspuid='SK0000000002'";
//            ResultSet resultSet = statement.executeQuery(sql);//执行sql，获取结果集
//
//            while (resultSet.next()) { //遍历结果集，取出数据
//                String Fspuid = resultSet.getString("Fspuid");
//                String Fspuonlinetitle = resultSet.getString("Fspuonlinetitle");
//                Date Fspuaddtime = resultSet.getDate("Fspuaddtime");
//                String Fsputitle = resultSet.getString("Fsputitle");
//                //输出数据
//                System.out.print("Fspuid：" + Fspuid);
//                System.out.print("，Fspuonlinetitle：" + Fspuonlinetitle);
//                System.out.print("，Fspuaddtime" + Fspuaddtime);
//                System.out.print(",Fsputitle" + Fsputitle);
//                System.out.println();
//            }
//            //4、关闭结果集、数据库操作对象、数据库连接
//            System.out.println("JDBC 未关闭连接 sql:[{" + sql + "}]耗时:[{" + per.PERFORM_TIME() + "}]");
//            resultSet.close();
//            statement.close();
//            connection.close();
//            System.out.println("JDBC sql:[{" + sql + "}]耗时:[{" + per.PERFORM_TIME() + "}]");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
//        ApplicationContext context = SpringUtil.getApplicationContext();
//        PerformanceUtil performanceUtil = new PerformanceUtil();
//        ConversionSpuMapper spuMapper = context.getBean(ConversionSpuMapper.class);
//        ConversionSpuPO spuPO = spuMapper.selectBySpuId(0, "SK0000000002");
//        if (spuPO != null) {
//            System.out.println("mybatis 耗时:[{" + performanceUtil.PERFORM_TIME() + "}]");
//        }
//
//    }
}