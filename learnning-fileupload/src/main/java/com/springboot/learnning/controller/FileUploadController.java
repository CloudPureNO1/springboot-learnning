package com.springboot.learnning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by CloudPure on 2017/12/28.
 */
@Controller
public class FileUploadController {
    @RequestMapping(value="/file",method = RequestMethod.GET)
    public String showPage(){
        return "/fileUpload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
      String fileName=  file.getOriginalFilename();
      String type=file.getContentType();
      String path=request.getSession().getServletContext().getRealPath("/files");
      File targe=new File(path);
      if(!targe.exists()) targe.mkdirs();
        try {
            FileOutputStream out=new FileOutputStream(path+fileName);
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
}
