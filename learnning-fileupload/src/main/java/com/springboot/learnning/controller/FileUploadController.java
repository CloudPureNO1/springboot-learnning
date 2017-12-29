package com.springboot.learnning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by CloudPure on 2017/12/28.
 */
@Controller
public class FileUploadController {
    @Value("${windows.upload.path}")
    private String windowsUploadPath;

    @Value("${linux.upload.path}")
    private String linuxUploadPath;
    @RequestMapping(value="/file",method = RequestMethod.GET)
    public String showPage(){
        return "fileUpload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request){
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(request instanceof MultipartHttpServletRequest);
      System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

      if(request instanceof MultipartHttpServletRequest){
          MultipartFile file=((MultipartHttpServletRequest) request).getFile("file");//C:\Users\CloudPure\Desktop\11\三十六计.txt
          String originalFilename=file.getOriginalFilename();//C:\Users\CloudPure\Desktop\11\三十六计.txt
          int iPositions=originalFilename.lastIndexOf("\\");
          int iPositione=originalFilename.lastIndexOf(".");//.txt
          String  fileName=originalFilename.substring(iPositions+1,iPositione);
          String suffix=originalFilename.substring(iPositione+1);
          String path=windowsUploadPath;

          File targe=new File(path);
          if(!targe.exists()) targe.mkdirs();

          try {
              FileOutputStream out=new FileOutputStream(new File(path+fileName+"."+suffix));
              out.write(file.getBytes());
              out.flush();
              out.close();
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              return e.toString();
          } catch (IOException e) {
              e.printStackTrace();
              return e.toString();
          }
          return "文件上传成功";
      }
     return "request if not a MultipartHttpServletRequest";

    }
}
