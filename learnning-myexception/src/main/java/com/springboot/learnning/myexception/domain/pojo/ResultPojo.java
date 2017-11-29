package com.springboot.learnning.myexception.domain.pojo;

import java.util.Date;

/**
 * Created by CloudPure on 2017/11/29.
 */
public class ResultPojo <T>{
    private Integer resultCode;//状态 0：成功，-1：失败
    private Integer resultStatus;//结果代码 比如400 404 500
    private String resultMsg;//结果信息  代码对应的信息
    private String requestURL;//当前请求的url
    private T data;//content 返回体报文的出参，使用泛型兼容不同的类型
    private Date date;//请求时间

    public ResultPojo() {
    }


    public ResultPojo(Integer resultCode, Integer resultStatus, String resultMsg, String requestURL, T data, Date date) {
        this.resultCode = resultCode;
        this.resultStatus = resultStatus;
        this.resultMsg = resultMsg;
        this.requestURL = requestURL;
        this.data = data;
        this.date = date;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
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
        if (!(o instanceof ResultPojo)) return false;

        ResultPojo<?> that = (ResultPojo<?>) o;

        if (resultCode != null ? !resultCode.equals(that.resultCode) : that.resultCode != null) return false;
        if (resultStatus != null ? !resultStatus.equals(that.resultStatus) : that.resultStatus != null) return false;
        if (resultMsg != null ? !resultMsg.equals(that.resultMsg) : that.resultMsg != null) return false;
        if (requestURL != null ? !requestURL.equals(that.requestURL) : that.requestURL != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = resultCode != null ? resultCode.hashCode() : 0;
        result = 31 * result + (resultStatus != null ? resultStatus.hashCode() : 0);
        result = 31 * result + (resultMsg != null ? resultMsg.hashCode() : 0);
        result = 31 * result + (requestURL != null ? requestURL.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultPojo{" +
                "resultCode=" + resultCode +
                ", resultStatus=" + resultStatus +
                ", resultMsg='" + resultMsg + '\'' +
                ", requestURL='" + requestURL + '\'' +
                ", data=" + data +
                ", date=" + date +
                '}';
    }
}
