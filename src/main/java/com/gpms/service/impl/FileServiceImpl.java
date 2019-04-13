package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.entity.FileInfo;
import com.gpms.dao.mapper.FileMapper;
import com.gpms.exception.FileException;
import com.gpms.service.FileService;
import com.gpms.utils.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {
    private final FileMapper fileMapper;

    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    @Transactional
    public int batch(List<MultipartFile> files, Integer userId) throws FileException{
        int lines = 0;
        for (int i = 0; i < files.size(); ++i) {
            MultipartFile file = files.get(i);
            String fullPath = write(files.get(i), i);
            String filename = file.getOriginalFilename();
            String suffixName = Objects.requireNonNull(filename).substring(filename.lastIndexOf(".") + 1);
            Integer size = Math.toIntExact(file.getSize());

            FileInfo fileInfo = new FileInfo();
            fileInfo.setName(filename.substring(0, filename.lastIndexOf(".")));
            fileInfo.setPath(fullPath);
            fileInfo.setExtension(suffixName);
            fileInfo.setSize(size);
            fileInfo.setOwner(userId);
            lines += fileMapper.insert(fileInfo);
        }
        return lines;
    }

    @Override
    public byte[] read(FileInfo fileInfo) throws FileException{
        if (fileInfo == null ) throw new FileException(500, "下载文件不存在！");
        String filePath = fileInfo.getPath();
        if (filePath != null) {
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    InputStream in = new FileInputStream(file);
                    byte[] body = new byte[in.available()];
                    in.read(body);
                    return body;
                } catch (FileNotFoundException e) {
                    throw new FileException(500, "下载文件不存在！");
                } catch (IOException e) {
                    throw new FileException(505, "下载出现错误！");
                }
            }
        }
        return null;
    }

    @Override
    public List<FileInfo> getFileInfos() {
        return fileMapper.selectList(null);
    }

    @Override
    public FileInfo getFileInfoById(Integer id) {
        return fileMapper.selectById(id);
    }

    @Override
    public List<FileInfo> getFileInfosByOwner(Integer ownerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", ownerId);
        return fileMapper.selectList(wrapper);
    }

    public String write(MultipartFile file, int idx) throws FileException {
        try {
            if (file.isEmpty()) {
                throw new FileException(400, "上传出错：文件不可为空！");
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 设置文件存储路径
            String filePath = Constant.FILE_DIR;
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return path;
        } catch (IllegalStateException | IOException e) {
            throw new FileException(401, "第" + idx + "个文件上传出错：" + e.getMessage());
        }

//        BufferedOutputStream stream;
//        if (!file.isEmpty()) {
//            try {
//                String filePath = Constant.FILE_DIR;
//                byte[] bytes = file.getBytes();
//                stream = new BufferedOutputStream(new FileOutputStream(
//                        new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
//                stream.write(bytes);// 写入
//                stream.close();
//            } catch (Exception e) {
//                throw new FileException(400, "第 " + idx + " 个文件上传出错: "
//                        + e.getMessage());
//            }
//        } else {
//            throw new FileException(401, "第 " + idx
//                    + " 个文件上传出错: 文件为空!");
//        }
    }
}
