package com.zisuye.rpc.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RpcTransport {
  private String host;

  private int port;

  public Object call(RpcRequest rpcRequest) {
    Object result = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    try (Socket socket = new Socket(host, port);) {
      oos = new ObjectOutputStream(socket.getOutputStream());
      // 序列化
      oos.writeObject(rpcRequest);
      oos.flush();

      ois = new ObjectInputStream(socket.getInputStream());
      // 获取服务端返回结果
      result = ois.readObject();
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    finally {
      if (ois != null) {
        try {
          ois.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (oos != null) {
        try {
          oos.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }
}
