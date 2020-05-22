package com.zisuye.rpc.bio;

public class ClientMain {
  public static void main(String[] args) {
    RpcClient rpcClient = new RpcClient();
    HelloService helloService = rpcClient.proxy(HelloService.class, "0.0.0.0", 8080);
    String content = helloService.sayHello("rpc simple demo");
    System.out.println("content = " + content);
  }
}
