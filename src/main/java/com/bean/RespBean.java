package com.bean;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/4/5 21:39
 * 该类用于封装返回给前端的数据
 */
public class RespBean {
    private String msg;
    private Integer status;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }

    public RespBean() {
    }


    public RespBean(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    //接收成功后数据
    public static RespBean ok(Object data) {
     return new RespBean(200,data);
    }


    //接收失败后数据
    public static RespBean err(Object data) {
      return  new RespBean(500,data);
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
