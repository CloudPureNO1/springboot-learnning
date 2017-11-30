package com.springboot.learnning.myexception.util;

import com.springboot.learnning.myexception.domain.enums.ResultEnum;
import com.springboot.learnning.myexception.domain.pojo.ResultInfo;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CloudPure on 2017/11/30.
 */
public class ResultUtil {
    private static final Logger logger= Logger.getLogger(ResultUtil.class);
    public static <T>ResultInfo<T> setResultInfo(int status,String msg,String url,T data,Date date){
        ResultInfo<T>resultInfo=null;
        try{
            resultInfo=new ResultInfo<T>();
            resultInfo.setStatus(status);
            resultInfo.setStaMsg(msg);
            resultInfo.setUrl(url);
            resultInfo.setData(data);
            resultInfo.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        }catch(Exception e){
            logger.error(ResultEnum.RESULTPOJO_SETVALUE_EXCEPTION.getOrdinal()+":"+ResultEnum.RESULTPOJO_SETVALUE_EXCEPTION.getName(),e );
        }
        return resultInfo;
    }
}
