package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.entity.FileInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FileMapper extends BaseMapper<FileInfo> {
    List<FileInfo> getFileInfosByRole(@Param("role") Integer role);
}
