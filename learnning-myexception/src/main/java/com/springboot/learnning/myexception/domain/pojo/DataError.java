package com.springboot.learnning.myexception.domain.pojo;

import org.springframework.stereotype.Component;

/**
 * Created by CloudPure on 2017/11/30.
 */
@Component
public class DataError {
    private String ClassName;
    private String mehtodName;
    private int lineNumber;
    private String exceptionMsg;

    public DataError() {
    }

    public DataError(String className, String mehtodName, int lineNumber) {
        ClassName = className;
        this.mehtodName = mehtodName;
        this.lineNumber = lineNumber;
    }

    public DataError(String className, String mehtodName, int lineNumber, String exceptionMsg) {
        ClassName = className;
        this.mehtodName = mehtodName;
        this.lineNumber = lineNumber;
        this.exceptionMsg = exceptionMsg;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getMehtodName() {
        return mehtodName;
    }

    public void setMehtodName(String mehtodName) {
        this.mehtodName = mehtodName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataError)) return false;

        DataError dataError = (DataError) o;

        if (getLineNumber() != dataError.getLineNumber()) return false;
        if (getClassName() != null ? !getClassName().equals(dataError.getClassName()) : dataError.getClassName() != null)
            return false;
        if (getMehtodName() != null ? !getMehtodName().equals(dataError.getMehtodName()) : dataError.getMehtodName() != null)
            return false;
        return getExceptionMsg() != null ? getExceptionMsg().equals(dataError.getExceptionMsg()) : dataError.getExceptionMsg() == null;
    }

    @Override
    public int hashCode() {
        int result = getClassName() != null ? getClassName().hashCode() : 0;
        result = 31 * result + (getMehtodName() != null ? getMehtodName().hashCode() : 0);
        result = 31 * result + getLineNumber();
        result = 31 * result + (getExceptionMsg() != null ? getExceptionMsg().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataError{" +
                "ClassName='" + ClassName + '\'' +
                ", mehtodName='" + mehtodName + '\'' +
                ", lineNumber=" + lineNumber +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                '}';
    }
}
