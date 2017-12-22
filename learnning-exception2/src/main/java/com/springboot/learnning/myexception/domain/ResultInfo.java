package com.springboot.learnning.myexception.domain;

import java.util.Date;

/**
 * Created by CloudPure on 2017/12/22.
 */
public class ResultInfo <T>{
    private Integer status;
    private String msg;
    private String url;
    private Date date;
    private T data;

    public ResultInfo() {
    }

    public ResultInfo(Integer status, String msg, String url,Date date, T data ) {
        this.status = status;
        this.msg = msg;
        this.url = url;
        this.data = data;
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultInfo)) return false;

        ResultInfo<?> that = (ResultInfo<?>) o;

        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getMsg() != null ? !getMsg().equals(that.getMsg()) : that.getMsg() != null) return false;
        if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) return false;
        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null) return false;
        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getStatus() != null ? getStatus().hashCode() : 0;
        result = 31 * result + (getMsg() != null ? getMsg().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", data=" + data +
                '}';
    }
}
