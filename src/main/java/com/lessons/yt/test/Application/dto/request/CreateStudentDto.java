package com.lessons.yt.test.Application.dto.request;

import lombok.Data;

@Data
public class CreateStudentDto {
    private String name;
    private String address;
    private String email;
    private Integer grade;
    private String password;
}
