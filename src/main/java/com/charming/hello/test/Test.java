package com.charming.hello.test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Test {
    public static void main(String[] args) {
       StringBuilder result = new StringBuilder();
       String id = UUID.randomUUID().toString();
       result.append("'").append(id.replaceAll("-","")).append("'");
        System.out.println(result);
//        Test();
    }

    public static void Test(){

        Game game = new Game();
        game.setName("PUBG");
        game.hashCode();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            game.setStartTime(sdf.parse("2019-03-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(game);
    }


    public static void  Test02() throws Exception {
        Properties properties = new Properties();
//        properties.load();
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();
        String sql = "select 1+1 as result;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);


    }


}
