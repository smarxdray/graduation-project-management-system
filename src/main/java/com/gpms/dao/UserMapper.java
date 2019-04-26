package com.gpms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
