package com.charming.hello.utils;

import ch.ethz.ssh2.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class SSHConectUtils {

    private static final Logger log = LoggerFactory.getLogger(SSHConectUtils.class);
    private static String  DEFAULTCHART="UTF-8";

    /**
     * 登录主机
     * @return
     *      登录成功返回true，否则返回false
     */
    public static Connection login(String ip,
                                   String userName,
                                   String userPwd){

        boolean flg=false;
        Connection conn = null;
        try {
            conn = new Connection(ip);
            conn.connect();//连接
            flg=conn.authenticateWithPassword(userName, userPwd);//认证
            if(flg){
                log.info("=========登录成功========="+conn);
                return conn;
            }
        } catch (IOException e) {
            log.error("=========登录失败========="+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }




}
