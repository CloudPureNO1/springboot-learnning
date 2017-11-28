package com.springboot.learnning.thymeleaf2.domain;

import java.io.Serializable;

/**
 * Created by CloudPure on 2017/11/27.
 */
public class LearnningResourse implements  Serializable{
    private String resourseName;
    private String resourseOwner;
    private String resourseURL;
    private String resourseDesc;

    public LearnningResourse(String resourseName, String resourseOwner, String resourseURL, String resourseDesc) {
        this.resourseName = resourseName;
        this.resourseOwner = resourseOwner;
        this.resourseURL = resourseURL;
        this.resourseDesc = resourseDesc;
    }

    public String getResourseName() {
        return resourseName;
    }

    public void setResourseName(String resourseName) {
        this.resourseName = resourseName;
    }

    public String getResourseOwner() {
        return resourseOwner;
    }

    public void setResourseOwner(String resourseOwner) {
        this.resourseOwner = resourseOwner;
    }

    public String getResourseURL() {
        return resourseURL;
    }

    public void setResourseURL(String resourseURL) {
        this.resourseURL = resourseURL;
    }

    public String getResourseDesc() {
        return resourseDesc;
    }

    public void setResourseDesc(String resourseDesc) {
        this.resourseDesc = resourseDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LearnningResourse)) return false;

        LearnningResourse that = (LearnningResourse) o;

        if (getResourseName() != null ? !getResourseName().equals(that.getResourseName()) : that.getResourseName() != null)
            return false;
        if (getResourseOwner() != null ? !getResourseOwner().equals(that.getResourseOwner()) : that.getResourseOwner() != null)
            return false;
        if (getResourseURL() != null ? !getResourseURL().equals(that.getResourseURL()) : that.getResourseURL() != null)
            return false;
        return getResourseDesc() != null ? getResourseDesc().equals(that.getResourseDesc()) : that.getResourseDesc() == null;
    }

    @Override
    public int hashCode() {
        int result = getResourseName() != null ? getResourseName().hashCode() : 0;
        result = 31 * result + (getResourseOwner() != null ? getResourseOwner().hashCode() : 0);
        result = 31 * result + (getResourseURL() != null ? getResourseURL().hashCode() : 0);
        result = 31 * result + (getResourseDesc() != null ? getResourseDesc().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LearnningResourse{" +
                "resourseName='" + resourseName + '\'' +
                ", resourseOwner='" + resourseOwner + '\'' +
                ", resourseURL='" + resourseURL + '\'' +
                ", resourseDesc='" + resourseDesc + '\'' +
                '}';
    }

    public LearnningResourse() {
    }
}
