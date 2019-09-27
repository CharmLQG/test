package com.charming.hello.thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHTTPServer {
    public static void main(String[] args) throws Exception {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("启动服务，绑定端口："+port);
        ExecutorService finxedThreadPool = Executors.newFixedThreadPool(30);
        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("新的连接"
                    +clientSocket.getInetAddress()+":"+clientSocket.getPort());
           try{
               finxedThreadPool.execute(new TreadTest(clientSocket));
           }catch (Exception e){
               System.out.println(e);
           }

        }

    }
}
