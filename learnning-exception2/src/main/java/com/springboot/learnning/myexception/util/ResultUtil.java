package com.springboot.learnning.myexception.util;

import com.springboot.learnning.myexception.domain.ResultInfo;
import com.springboot.learnning.myexception.domain.enums.ExceptionEnum;
import com.springboot.learnning.myexception.domain.exception.BaseException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CloudPure on 2017/12/22.
 */
public class ResultUtil {
    private static Logger logger= Logger.getLogger(ResultInfo.class);
    public static <T>ResultInfo<T> getResult(Integer status,String msg,String url,T data) throws BaseException {
        ResultInfo<T> resultInfo=null;
        try {
            resultInfo=new ResultInfo<T>();
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date=null;
            date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            resultInfo.setStatus(status);
            resultInfo.setMsg(msg);
            resultInfo.setUrl(url);
            resultInfo.setDate(date);
            resultInfo.setData(data);
        } catch (ParseException e) {
            logger.error("时间格式化异常："+e.toString(),e);
            throw new BaseException(ExceptionEnum.ParseException);
        } catch (Exception e){
            logger.error("设置还回结果异常："+e.toString(),e);
            throw new BaseException(ExceptionEnum.SetResultInfoException);
        }
        return resultInfo;
    }
}
