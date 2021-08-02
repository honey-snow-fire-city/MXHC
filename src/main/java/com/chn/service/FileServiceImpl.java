package com.chn.service;

import com.chn.dao.FileMapper;
import com.chn.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    public List<Files> queryAllFile() {
        return fileMapper.queryAllFile();
    }

    public int uploadFile(Files files) {
        return fileMapper.uploadFile(files);
    }
}
