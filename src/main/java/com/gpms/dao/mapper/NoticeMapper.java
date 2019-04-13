package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Notice> getNoticesByUserId(@Param("userId") Integer userId);
}
