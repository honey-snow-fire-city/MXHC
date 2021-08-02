package com.chn.dao;

import com.chn.pojo.Files;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {
    //查看文件
    List<Files> queryAllFile();
    //上传文件
    int uploadFile(Files files);
}
