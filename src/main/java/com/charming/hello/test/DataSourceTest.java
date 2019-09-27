package com.charming.hello.test;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataSourceTest {
    public static ConcurrentHashMap<String, DataSourceInfo> dataSourceMap = new ConcurrentHashMap<>(16);

    public static synchronized DataSource getDataSource(SysDataSource ds) {
        new Thread(DataSourceTest::clearDateSource).start();
        DataSourceInfo dataSourceInfo = dataSourceMap.get(ds.getId());
        if (dataSourceInfo == null) {
            dataSourceInfo = creteDateSource(ds);
            dataSourceMap.put(ds.getId(), dataSourceInfo);
            return dataSourceInfo.getDataSource();
        } else {
            if (ds.hashCode() == dataSourceInfo.getHashCode()) {
                dataSourceInfo.setLastTime(LocalDateTime.now());
                dataSourceMap.put(ds.getId(), dataSourceInfo);
                return dataSourceInfo.getDataSource();
            } else {
                //连接信息变更
                try {
                    dataSourceInfo.getDataSource().getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dataSourceMap.remove(ds.getId());
                dataSourceInfo = creteDateSource(ds);
                dataSourceMap.put(ds.getId(), dataSourceInfo);
                return dataSourceInfo.getDataSource();
            }
        }
    }


    /**
     * 清理闲置1小时以上的DataSource
     */
    private static synchronized void clearDateSource(){
        if (!dataSourceMap.isEmpty()){
            List<DataSourceInfo> infos = dataSourceMap.values().stream().sorted(Comparator.comparing(DataSourceInfo::getLastTime)).collect(Collectors.toList());
            for (DataSourceInfo info : infos) {
                if (info.getLastTime().isBefore(LocalDateTime.now().minusHours(1))){
                    try {
                        dataSourceMap.get(info.getId()).getDataSource().getConnection().close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    dataSourceMap.remove(info.getId());
                }else {
                    break;
                }
            }
        }
    }

    /**
     * 创建新的DataSource
     * @param ds
     * @return
     */
    private static synchronized DataSourceInfo creteDateSource(SysDataSource ds) {
        BasicDataSource newDataSource = new BasicDataSource ();
        DataSourceTypeEnum typeEnum = ds.getDriverClass();
        newDataSource.setDriverClassName(typeEnum.getClassName());
        if (StringUtil.isEmpty(ds.getUrl())) {
            String jdbcUrl = "";
            switch (typeEnum) {
                case MYSQL:
                    jdbcUrl = "jdbc:mysql://" + ds.getIp() + ":" + ds.getPort() + "/" + ds.getDatabase();
                    break;
                case PGSQL:
                    jdbcUrl = "jdbc:postgresql://" + ds.getIp() + ":" + ds.getPort() + "/" + ds.getDatabase();
                    break;
                case MARIADB:
                    jdbcUrl = "jdbc:mysql://" + ds.getIp() + ":" + ds.getPort() + "/" + ds.getDatabase();
                    break;
                default:
                    break;
            }
            newDataSource.setUrl(jdbcUrl);
        } else {
            newDataSource.setUrl(ds.getUrl());
        }
        newDataSource.setUsername(ds.getUsername());
        newDataSource.setPassword(ds.getPassword());
        return DataSourceInfo.builder()
                .id(ds.getId())
                .hashCode(ds.hashCode())
                .dataSource(newDataSource)
                .lastTime(LocalDateTime.now())
                .build();
    }
}
