package com.zisuye.rpc.bio;

import java.io.Serializable;
import lombok.Data;

@Data
public class RpcRequest implements Serializable {
  private String className;

  private String methodName;

  private Object[] params;
}
