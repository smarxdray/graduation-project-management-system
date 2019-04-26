package com.gpms.domain;

import com.gpms.domain.dto.StudentDetailDTO;
import com.gpms.domain.entity.User;
import lombok.Data;

@Data
public class Student {
    private User basic;
    private StudentDetailDTO detail;

    public User getBasic() {
        return basic;
    }

    public void setBasic(User basic) {
        this.basic = basic;
    }

    public StudentDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(StudentDetailDTO detail) {
        this.detail = detail;
    }
}