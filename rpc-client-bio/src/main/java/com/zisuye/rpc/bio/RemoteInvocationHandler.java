package com.zisuye.rpc.bio;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RemoteInvocationHandler implements InvocationHandler {

  private String host;

  private int port;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("需要动态代理生成请求对象");
    // 构建 RpcRequest
    RpcRequest rpcRequest = new RpcRequest();
    rpcRequest.setClassName(method.getDeclaringClass().getName());
    rpcRequest.setMethodName(method.getName());
    rpcRequest.setParams(args);

    // 远程调用
    RpcTransport rpcTransport = new RpcTransport(host, port);
    Object result = rpcTransport.call(rpcRequest);
    return result;
  }
}
