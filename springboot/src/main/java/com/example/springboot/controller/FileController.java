package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.*;

import static com.example.springboot.web.FileUtil.fileDownLoad1;
import static com.example.springboot.web.FileUtil.fileUpload1;

/**
 * @ClassName: FileController
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/4/2412:08
 */
@Controller
@RequestMapping("/")
public class FileController {

    /**
     * 文件页面
     * @return
     */
    @GetMapping("fileIndex.html")
    public String demo() {
        System.out.println("hello");
        return "index";
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("fileName") MultipartFile file){
        System.out.println("文件大小:"+file.getSize()/(1024*1024)+"MB");
        boolean b = fileUpload1(file);
        return b+"";
    }

    /**
     * 文件下载
     * @param response
     * @return
     */
    @RequestMapping("download")
    public String download1(HttpServletResponse response) {
        String filename = "2.txt";
        fileDownLoad1(response,filename);
        return null;
    }


}
