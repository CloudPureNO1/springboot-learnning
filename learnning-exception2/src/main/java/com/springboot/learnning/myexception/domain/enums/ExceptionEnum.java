package com.springboot.learnning.myexception.domain.enums;

import org.apache.log4j.Logger;

/**
 * Created by CloudPure on 2017/12/22.
 */
public enum ExceptionEnum {
    SUCCESS("SUCCESS",0),//成功
    FAILURE("FAILURE",-1),//失败
    UndefindeException("undefined exception",-2),//系统未定义或未知异常

    ENUM_TRANSLATION_EXCEPTION("枚举类型转换异常",-3),//枚举类型转换异常：比如，根据枚举类型，取得枚举类型名称的标识描述，和序列号


    SetResultInfoException("设置结果异常",3000),//设置结果异常

    NullPointerException("java.lang.NullPointerException",7000),//空指针异常
    ParseException("java.text.ParseException",7001),//时间格式化异常
    NumberFormatException("java.lang.NumberFormatException",7002),//数字格式化异常


    ;
    //如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
    // 而且 Java 要求必须先定义 enum 实例。

    private static final Logger logger= Logger.getLogger(ExceptionEnum.class);
    private String name;//枚举常量的名称，也就是：用来声明它的标识符
    private int ordinal;//枚举常量的常数-枚举常数,也就是它在枚举声明这种的位置，默认设置初始为0

    ExceptionEnum(String name, int ordinal){
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
        for(ExceptionEnum exceptionEnum : ExceptionEnum.values()){
            if(ordinal== exceptionEnum.ordinal){
                return exceptionEnum.name;
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
            enumConstrantName= ExceptionEnum.valueOf(enumConstrantType).name;
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
        int enumConstrant= ExceptionEnum.ENUM_TRANSLATION_EXCEPTION.ordinal;//枚举类型对应的枚举常量：即：ordinal
        try{
            enumConstrant= ExceptionEnum.valueOf(enumConstrantType).ordinal;
        }catch (IllegalArgumentException ilge){
            logger.error("指定的枚举类型"+enumConstrantType+"没有指定名称的常量："+ilge.getMessage(),ilge);
        }catch(NullPointerException ne){
            logger.error("枚举类型或名称为null，发生空指针异常:"+ne.getMessage(),ne);
        }
        return enumConstrant;
    }




}
