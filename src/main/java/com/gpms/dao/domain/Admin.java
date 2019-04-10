package com.gpms.dao.domain;

import com.gpms.dao.domain.entity.AdminDetails;
import com.gpms.dao.domain.entity.User;
import lombok.Data;

@Data
public class Admin {
    User basic;
    AdminDetails details;
}
