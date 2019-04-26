package com.gpms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.domain.entity.FileInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FileMapper extends BaseMapper<FileInfo> {
    List<FileInfo> getFileInfosByRole(@Param("role") Integer role);
}
