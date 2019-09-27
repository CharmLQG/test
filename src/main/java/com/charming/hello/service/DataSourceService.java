package com.charming.hello.service;

import com.charming.hello.dao.DataSourceDao;
import com.charming.hello.test.DataSourceTest;
import com.charming.hello.test.SysDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSourceService {
    /**
     *
     */
    @Autowired
    DataSourceDao dataSourceDao;

    public SysDataSource testDemo(String id){
//        String rtnAfterDosomething = "我是返回结果";
//        //这里是业务代码
//        return rtnAfterDosomething;
        SysDataSource dataSource =dataSourceDao.getDataSource(id);
        return (SysDataSource) DataSourceTest.getDataSource(dataSource);
    }

}
