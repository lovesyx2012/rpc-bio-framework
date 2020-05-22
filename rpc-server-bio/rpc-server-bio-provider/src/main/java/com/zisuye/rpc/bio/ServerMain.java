package com.zisuye.rpc.bio;

public class ServerMain {
  public static void main(String[] args) {
    HelloService helloService = new HelloServiceImpl();

    RpcServer rpcServer = new RpcServer();
    rpcServer.start(helloService, 8080);
  }
}
