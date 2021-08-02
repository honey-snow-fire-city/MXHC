package com.chn.controller;

import com.chn.pojo.Files;
import com.chn.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    public FileService fileService;

    @RequestMapping("/queryFile")
    public String queryFile(Model model){
        System.out.println("文件上传");
        List<Files> files = fileService.queryAllFile();
        model.addAttribute("files",files);
        System.out.println("上传文件");
        return "allFile";
    }

    @RequestMapping("/goAddFile")
    public String goAddFile(){
        return "addFile";
    }

    @RequestMapping("/addFile")
    public String AddFile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request,Model model){
        System.out.println("你好");
        // 以当前日期创建一个文件夹，避免单个文件夹中文件过多
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String substring = timestamp.toString().substring(0,10);
        // 设置文件上传存放的路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/" + substring);

        System.out.println("获取到图片上传地址为：" + uploadPath);
        // 获取上传文件名字
        String uploadName = file.getOriginalFilename();
        System.out.println("原始文件名："+ uploadName);
        // 利用UUID生成新的图片名字，避免原图片被覆盖
        String uuid = UUID.randomUUID().toString();

        // 截取上传文件的后缀
        String suffix = uploadName.substring(uploadName.lastIndexOf("."));
        // 拼接新的文件名字
        String newUploadName = uuid + suffix;
        System.out.println("新的文件名：" + newUploadName);

        File dir = new File(uploadPath,newUploadName);
        if (!dir.exists()){
            dir.mkdirs();
        }

        try {
            file.transferTo(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/file/allFile";
    }
}
