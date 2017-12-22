package com.springboot.learnning.myexception.domain;

/**
 * Created by CloudPure on 2017/12/22.
 */
public class ExceptionData {
    private String exceptionMsg;
    private String className;
    private String methodName;
    private Integer lineNumber;

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "ExceptionData{" +
                "exceptionMsg='" + exceptionMsg + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExceptionData)) return false;

        ExceptionData that = (ExceptionData) o;

        if (exceptionMsg != null ? !exceptionMsg.equals(that.exceptionMsg) : that.exceptionMsg != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        return lineNumber != null ? lineNumber.equals(that.lineNumber) : that.lineNumber == null;
    }

    @Override
    public int hashCode() {
        int result = exceptionMsg != null ? exceptionMsg.hashCode() : 0;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (lineNumber != null ? lineNumber.hashCode() : 0);
        return result;
    }

    public ExceptionData() {
    }

    public ExceptionData(String exceptionMsg, String className, String methodName, Integer lineNumber) {
        this.exceptionMsg = exceptionMsg;
        this.className = className;
        this.methodName = methodName;
        this.lineNumber = lineNumber;
    }
}
