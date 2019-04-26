package com.gpms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.domain.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Notice> getNoticesByReceiver(@Param("userId") Integer userId);
}
