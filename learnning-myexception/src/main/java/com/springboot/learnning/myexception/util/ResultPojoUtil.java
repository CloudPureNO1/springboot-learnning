package com.springboot.learnning.myexception.util;

import com.springboot.learnning.myexception.domain.enums.ResultStatus;
import com.springboot.learnning.myexception.domain.pojo.ResultPojo;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by CloudPure on 2017/11/29.
 */
public class ResultPojoUtil {
    private static final Logger LOGGER= Logger.getLogger(ResultPojoUtil.class);


    /**
     * 成功时返回的restful结果
     * @param equestURI
     * @param data
     * @param date
     * @param <T>
     * @return
     */
    public static <T>ResultPojo<T> setResultPojoSuccess(String equestURI, T data, Date date){
        ResultPojo<T> resultPojo=null;
        try{
          resultPojo=new ResultPojo<T>();
          resultPojo.setResultCode(ResultStatus.SUCCESS.getCode());
          resultPojo.setResultStatus(ResultStatus.SUCCESS.getCode());
          resultPojo.setResultMsg(ResultStatus.SUCCESS.getMsg());
          resultPojo.setRequestURL(equestURI);
          resultPojo.setData(data);
          resultPojo.setDate(date);
          LOGGER.info("**************成功时还回result：{}"+resultPojo.toString()+"*******************");
      }catch(Exception e){
          LOGGER.info("设置还回result时发生异常："+e.getMessage(),e);
      }
        return resultPojo;
    }

    public static <T>ResultPojo<T> setResultPojoFailure(){
        ResultPojo<T> resultPojo=null;
        try{
            resultPojo
            LOGGER.info("**************失败时还回result：{}"+resultPojo.toString()+"*******************");
        }catch (Exception e){
            LOGGER.info("设置还回result时发生异常："+e.getMessage(),e);
        }
        return resultPojo;
    }

}
