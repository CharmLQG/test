package com.charming.hello.dao;

import com.charming.hello.base.MyBatisDAO;
import com.charming.hello.test.SysDataSource;

@MyBatisDAO
public interface DataSourceDao {
    SysDataSource getDataSource(String id);
}