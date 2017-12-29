package com.springboot.learnning.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2017/12/29.
 */
@Controller
@RequestMapping(value = "/file")
public class FileUploadController {
    private static final Logger logger= Logger.getLogger(FileUploadController.class);

    @Value("${windows.upload.path}")
    private String windowsUploadPath;
    @Value("${linux.upload.path}")
    private String linuxUploadPath;

    @RequestMapping(value = "/fileUpload")
    public String showUpload(){
        return "/fileUpload";
    }

    @RequestMapping(value = "/sigleUpload",method = RequestMethod.POST)
    public String uploadSigleFile(HttpServletRequest request){
        String sResult="";
        if(request instanceof MultipartHttpServletRequest){
             MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
             MultipartFile file=multipartHttpServletRequest.getFile("sigleFile");
             sResult=upload(file,windowsUploadPath,null,null);
        }

        request.setAttribute("sigleMsg",sResult);
        return "/fileUpload";
    }

    @RequestMapping(value="/multiUpload",method = RequestMethod.POST)
    public ModelAndView uploadMultiFile(HttpServletRequest request){
        String sResult="";
        if(request instanceof MultipartHttpServletRequest){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            List<MultipartFile> listFile= multipartHttpServletRequest.getFiles("multiFile");
            if(listFile!=null&&listFile.size()>0){
                for(MultipartFile file:listFile){
                   sResult+= upload(file,windowsUploadPath,null,null);
                }
            }else{
                sResult="没有要上传的文件";
            }

        }




        ModelAndView modelAndView=new ModelAndView("/fileUpload");
        modelAndView.addObject("multiMsg",sResult);
        return modelAndView;
    }


    /**
     *
     * @param file
     * @param uploadPath  上传文件路径,不能为空
     * @param fileName 上传后的文件名： 为空(null 或者空白字符） 时，等于上传时的文件名
     * @param suffix 文件后缀名：为空（null 或者空白字符）时，等于上传是的文件后缀
     * @return  sResult 还回文件上传成功或失败的信息
     */
    private String upload(MultipartFile file,String uploadPath,String fileName,String suffix){
        String sResult="";
        String originalFilename=file.getOriginalFilename();
        int iSPosition=originalFilename.lastIndexOf("\\");
        int iEPosition=originalFilename.lastIndexOf(".");
        if (StringUtils.isEmptyOrWhitespace(suffix)) suffix=originalFilename.substring(iEPosition+1);
        if(StringUtils.isEmptyOrWhitespace(fileName)) fileName=originalFilename.substring(iSPosition+1,iEPosition);
        if(StringUtils.isEmptyOrWhitespace(uploadPath)) sResult="上传路径为空！";
        File target=new File(uploadPath);
        if(!target.exists()) target.mkdirs();//不存在则创建路径
        BufferedOutputStream bufferedOutputStream=null;
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(new File(uploadPath+fileName+"."+suffix));
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte [] bytes=file.getBytes();
            bufferedOutputStream.write(bytes,0,bytes.length);
            bufferedOutputStream.flush();
            sResult+="文件上传成功";
        } catch (FileNotFoundException e) {
            sResult+="创建新文件发生异常："+e.toString();
            logger.error("创建新文件发生异常："+e.toString(),e);
        } catch (IOException e) {
            sResult+="获取文件流时发生异常："+e.toString();
            logger.error("获取文件流时发生异常："+e.toString(),e);
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                sResult+="关闭输出流时发生异常："+e.toString();
                logger.error("关闭输出流时发生异常："+e.toString(),e);
            }
        }

        return sResult;
    }



}
