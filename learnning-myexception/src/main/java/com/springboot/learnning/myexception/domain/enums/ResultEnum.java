package com.springboot.learnning.myexception.domain.enums;

import com.springboot.learnning.myexception.domain.pojo.ResultInfo;
import com.sun.net.httpserver.Authenticator;
import org.apache.log4j.Logger;

/**
 * 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
 * 而且 Java 要求必须先定义 enum 实例。
 * Created by CloudPure on 2017/11/30.
 */
public enum ResultEnum {
    SUCCESS("SUCCESS",0),//成功
    FAILURE("FAILURE",-1),//失败
    UNKNOWN("UNKOWN EXCEPTION",-2),//系统未定义或未知异常

    ENUM_TRANSLATION_EXCEPTION("枚举类型转换异常",9001),//枚举类型转换异常：比如，根据枚举类型，取得枚举类型名称的标识描述，和序列号
    RESULTPOJO_SETVALUE_EXCEPTION("ResultPoJo实例对象赋值时发生异常",9002),

    ;
    //如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
    // 而且 Java 要求必须先定义 enum 实例。

    private static final Logger logger= Logger.getLogger(ResultEnum.class);
    private String name;//枚举常量的名称，也就是：用来声明它的标识符
    private int ordinal;//枚举常量的常数-枚举常数,也就是它在枚举声明这种的位置，默认设置初始为0

     ResultEnum(String name,int ordinal){
        this.name=name;
        this.ordinal=ordinal;
    }
    public void setName(String name){
         this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setOrdinal(int ordinal){
        this.ordinal=ordinal;
    }
    public int getOrdinal(){
        return ordinal;
    }



    public static String getName(int ordinal){
        for(ResultEnum resultEnum:ResultEnum.values()){
            if(resultEnum.ordinal==ordinal){
                return resultEnum.name;
            }
        }
        return "没有枚举常数"+ordinal+"对应的枚举常量!";
    }

    /**
     * 根据枚举类型的字符串，取得指定枚举类型指定的名称
     * 枚举的valueOf 方法抛出异常:
     * Throws:
     1、IllegalArgumentException - if the specified enum type has no constant with the specified name,
         or the specified class object does not represent an enum type
     2、NullPointerException - if enumType or name is null
     * @param enumConstrantType  枚举类型字符串：如：ResultEnum.SUCCESS
     * @return
     */
    public static String getName(String enumConstrantType){
        String enumConstrantName=null;//就是枚举类型指定名称
        try{
            enumConstrantName= ResultEnum.valueOf(enumConstrantType).name;
        }catch (IllegalArgumentException ilge){
            enumConstrantName="指定的枚举类型"+enumConstrantType+"没有指定名称的常量："+ilge.getMessage();
            logger.error("指定的枚举类型"+enumConstrantType+"没有指定名称的常量："+ilge.getMessage(),ilge);
        }catch(NullPointerException ne){
            enumConstrantName="枚举类型或名称为null，发生空指针异常:"+ne.getMessage();
            logger.error("枚举类型或名称为null，发生空指针异常:"+ne.getMessage(),ne);
        }
        return enumConstrantName;
    }


    /**
     * * 根据枚举类型的字符串，取得指定枚举类型指定的名称
     * 枚举的valueOf 方法抛出异常:
     * Throws:
     1、IllegalArgumentException - if the specified enum type has no constant with the specified name,
     or the specified class object does not represent an enum type
     2、NullPointerException - if enumType or name is null
     * @param enumConstrantType  枚举类型，如：ResultEnum.SUCCESS
     * @return odinal  枚举类型对应的枚举常量
     */
    public static int getOrdinal(String enumConstrantType){
        int enumConstrant=ResultEnum.ENUM_TRANSLATION_EXCEPTION.ordinal;//枚举类型对应的枚举常量：即：ordinal
        try{
            enumConstrant= ResultEnum.valueOf(enumConstrantType).ordinal;
        }catch (IllegalArgumentException ilge){
            logger.error("指定的枚举类型"+enumConstrantType+"没有指定名称的常量："+ilge.getMessage(),ilge);
        }catch(NullPointerException ne){
            logger.error("枚举类型或名称为null，发生空指针异常:"+ne.getMessage(),ne);
        }
        return enumConstrant;
    }



}
