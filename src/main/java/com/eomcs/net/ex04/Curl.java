package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Curl {

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("www.kostat.go.kr", 80)) {

      PrintStream out = new PrintStream(socket.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // 웹 서버에 요청
      out.println("GET /portal/korea/index.action HTTP/1.1");
      out.println("Host: www.kostat.go.kr");
      out.println();

      // 웹 서버 응답 받기
      String str = null;
      while ((str = in.readLine()) != null) {
        System.out.println(str);
      }

    }
  }
}
