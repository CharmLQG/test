package com.charming.hello.test;

/**
 * 只适用于pgsql的jdbc type转换枚举
 */
public enum DataSourceTypeEnum {
    MYSQL("com.mysql.jdbc.Driver", "MySQL数据库"),
    MARIADB("com.mysql.jdbc.Driver", "MariaDB数据库"),
    PGSQL("org.postgresql.Driver", "PostgreSQL数据库");


    private String className;

    private String desc;

    DataSourceTypeEnum(String className, String desc) {
        this.className = className;
        this.desc = desc;
    }

    public static String className(String type) {
        for (DataSourceTypeEnum typeEnum : DataSourceTypeEnum.values()) {
            if (type.equals(typeEnum.name())) {
                return typeEnum.className;
            }
        }
        return DataSourceTypeEnum.PGSQL.className;
    }

    public static String desc(String type) {
        for (DataSourceTypeEnum typeEnum : DataSourceTypeEnum.values()) {
            if (type.equals(typeEnum.name())) {
                return typeEnum.desc;
            }
        }
        return DataSourceTypeEnum.PGSQL.desc;
    }


//    public static Map<String, String> typeDesc() {
//        Map<String, String> result = Maps.newHashMap();
//        for (DataSourceTypeEnum typeEnum : DataSourceTypeEnum.values()) {
//            result.put(typeEnum.name(), typeEnum.desc);
//        }
//        return result;
//    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
