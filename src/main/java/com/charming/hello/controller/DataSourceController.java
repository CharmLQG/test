package com.charming.hello.controller;

import com.charming.hello.service.DataSourceService;
import com.charming.hello.test.SysDataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api("测试数据源")
public class DataSourceController {

    @Autowired
    DataSourceService dataSourceService;

    @ApiOperation("获取数据源")
    @GetMapping("sysDataSource/{id}")
    public SysDataSource test(String id){
        return dataSourceService.testDemo(id);
    }


}
