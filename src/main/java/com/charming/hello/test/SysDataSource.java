package com.charming.hello.test;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SysDataSource extends BaseModel<String> {

    //数据源名称
    private String name;

    //
    private String tag;

    private DataSourceTypeEnum driverClass;

    private String url;

    private String ip;

    private String port;

    private String database;

    private String username;

    private String password;

    private String schema;

}