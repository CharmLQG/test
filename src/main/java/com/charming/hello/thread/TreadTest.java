package com.charming.hello.thread;

import java.io.*;
import java.net.Socket;

public class TreadTest implements Runnable {

    final static String CRLF = "\r\n";

    private Socket clientSocket;

    public TreadTest(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void handleSocket(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
                );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),
                true
                );

        String requestHeader = "";
        String s;
        while ((s = in.readLine())!=null){
            s += CRLF;
            requestHeader = requestHeader+s;
            if (s.equals(CRLF)){
                break;
            }
        }

        System.out.println("客户端请求头：");
        System.out.println(requestHeader);

        String responsBody = "客户端请求头是：\n"+requestHeader;
        String responseHeader = "HTTP/1.0 200 OK\r\n"+
                "Content-Type:text/plain;charset=UTF-8\r\n"+
                "Content-Length:"+responsBody.getBytes().length+"\r\n"+
                "\r\n";

        System.out.println("响应头：");

        System.out.println(responseHeader);

        out.write(responseHeader);
        out.write(responsBody);
        out.flush();
        out.close();
        clientSocket.close();
    }

    @Override
    public void run() {
        try {
            handleSocket(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

