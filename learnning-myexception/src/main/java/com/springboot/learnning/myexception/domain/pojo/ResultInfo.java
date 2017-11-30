package com.springboot.learnning.myexception.domain.pojo;

/**
 * Created by CloudPure on 2017/11/30.
 */
public class ResultInfo<T> {
    private Integer status;//还回结果状态码：比如400,404,500,0，-1 等
    private String staMsg;//还回结果状态码对应的信息说明或状态对应名称：比如 0-成功，-1-失败，404-not found等
    private String url;//还回请求的url
    private String date;//还回 时间：格式：yyyy-MM-dd HH:mm:ss
    private T data;//还回数据

    public ResultInfo() {
    }

    public ResultInfo(Integer status, String staMsg, String url, String date) {
        this.status = status;
        this.staMsg = staMsg;
        this.url = url;
        this.date = date;
    }

    public ResultInfo(Integer status, String staMsg, String url, String date, T data) {
        this.status = status;
        this.staMsg = staMsg;
        this.url = url;
        this.date = date;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStaMsg() {
        return staMsg;
    }

    public void setStaMsg(String staMsg) {
        this.staMsg = staMsg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultInfo)) return false;

        ResultInfo<?> that = (ResultInfo<?>) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (staMsg != null ? !staMsg.equals(that.staMsg) : that.staMsg != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (staMsg != null ? staMsg.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "status=" + status +
                ", staMsg='" + staMsg + '\'' +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                ", data=" + data +
                '}';
    }
}
