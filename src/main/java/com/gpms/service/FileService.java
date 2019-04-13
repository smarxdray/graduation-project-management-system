package com.gpms.service;

import com.gpms.dao.domain.entity.FileInfo;
import com.gpms.exception.FileException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<FileInfo> getFileInfos();
    List<FileInfo> getFileInfosByOwner(Integer ownerId);
    FileInfo getFileInfoById(Integer id);
    String write(MultipartFile file, int idx) throws FileException;
    int batch(List<MultipartFile> files, Integer userId)  throws FileException;
    byte[] read(FileInfo fileInfo) throws FileException;
}
