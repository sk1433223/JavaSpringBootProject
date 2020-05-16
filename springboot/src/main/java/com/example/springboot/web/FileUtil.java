package com.example.springboot.web;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName: FileUtil
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/4/2411:04
 */
public class FileUtil {

    /**
     * 文件上传封装
     * @param file
     * @return
     */
    public static boolean fileUpload1(MultipartFile file) {
        if (file.isEmpty()){
            return false;
        }
        String path = "F:/test";
        String filename = file.getOriginalFilename();
        /*System.out.println("1:"+filename);
        String prefix = filename.substring(0, filename.lastIndexOf(".")); // 文件名
        String suffix = filename.substring(filename.lastIndexOf("."));  // 扩展名
        System.out.println("prefix:"+prefix);
        System.out.println("suffix:"+suffix);*/
        File dest = new File(path+"/"+filename);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        number();

    }

    /**
     * 五位随机数
     * @return
     */
    public static int number() {
        int num = (int) ((Math.random()*9+1)*10000);
        System.out.println(num);
        return num;
    }


    /**
     * 文件下载
     * @param response
     * @param strFileName
     */
    public static String fileDownLoad1(HttpServletResponse response,String strFileName) {
        String path = "F:/test";
        File file = new File(path+"/"+strFileName);
        if (file.exists()){
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            try {
                response.setHeader("Content-Disposition", "attachment;fileName="+java.net.URLEncoder.encode(strFileName,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "false";
            }
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
                System.out.println("下载成功");
            } catch (Exception e) {
                e.printStackTrace();
                return "false";
            }
            System.out.println("----------file download---" + strFileName);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "未知错误!";
            }
        }
        return "true";
    }


}
