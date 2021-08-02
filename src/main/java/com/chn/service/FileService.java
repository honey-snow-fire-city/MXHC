package com.chn.service;

import com.chn.pojo.Files;

import java.util.List;

public interface FileService {
    //查看文件
    List<Files> queryAllFile();
    //上传文件
    int uploadFile(Files files);
}
