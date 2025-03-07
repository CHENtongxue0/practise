package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Description UploadController
 * @Author songyu
 * @Date 2025-01-03  10:37
 */
@RestController
public class UploadController {

    /**
     * 本地磁盘文件上传
     * @param file
     * @return
     *
     * MultipartFile 这是springmvc框架提供的技术，封装了获取前端传递过来的文件对象
     */
//    @PostMapping("/upload")
//    public Result upload1(MultipartFile file){
//        //1.生成唯一新文件名（不可以使用上传的文件名，因为不同的用户上传文件可能重名）
//        //1.1 获取原始删除文件的扩展名（xxx.jpg的扩展名.jpg）
//        String originalFilename = file.getOriginalFilename();//获取上传文件原始文件名 xxx.jpg
//        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));//.jpg
//        //1.2 生成唯一值的文件名
//        // UUID 通用唯一码，是jdk提供的生成唯一值的工具类
//        String newFileName = UUID.randomUUID().toString() + extName;//alkdaljkkdlolieltj4jwj4.jpg
//
//        try {
//            //2.保存到磁盘 D:\imgs 目录下
//            file.transferTo(new File("D:\\imgs",newFileName));//将文件保存写入在 D:\imgs\alkdaljkkdlolieltj4jwj4.jpg
//
//            //3.封装数据返回
//            //data = http://localhost:8080/download?filename=新文件名
//            return Result.success("http://localhost:8080/download?filename="+newFileName);
//        } catch (IOException e) {
//            e.printStackTrace(); //异常打印，方便开发人员解决文档
//            return Result.error("文件上传失败，失败原因："+e.getMessage());
//        }
//    }

    /**
     * 处理本地文件下载
     * HttpServletResponse response 从spring容器中获取响应对象，因为可以获取响应输出流来输出图片
     * @param filename
     * @param response
     */
    @GetMapping("/download")
    public void download(String filename, HttpServletResponse response) throws Exception {

        //1.根据传入文件名filename，去读取磁盘D:\imgs 目录下这个文件获取输入流
        InputStream input = new FileInputStream("d:\\imgs\\"+filename);

        //2.将图片输入流给到响应输出流，这样前端浏览器就可以看到图片文件了
        IOUtils.copy(input,response.getOutputStream());
    }

    @PostMapping("/upload")
    public Result upload1(MultipartFile file){
        //1.生成唯一新文件名（不可以使用上传的文件名，因为不同的用户上传文件可能重名）
        //1.1 获取原始删除文件的扩展名（xxx.jpg的扩展名.jpg）
        String originalFilename = file.getOriginalFilename();//获取上传文件原始文件名 xxx.jpg
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));//.jpg
        //1.2 生成唯一值的文件名
        // UUID 通用唯一码，是jdk提供的生成唯一值的工具类
        String newFileName = UUID.randomUUID().toString() + extName;//alkdaljkkdlolieltj4jwj4.jpg
        try {
            //2.上传到阿里oss
            String uploadPath = AliOSSUtil.upload(newFileName, file.getInputStream());

            //3.封装数据返回
            return Result.success(uploadPath);
        } catch (Exception e) {
            e.printStackTrace(); //异常打印，方便开发人员解决文档
            return Result.error("文件上传失败，失败原因："+e.getMessage());
        }
    }

}


