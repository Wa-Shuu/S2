package com.washuu.s2.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Data
@ToString
@Repository
public class RegisterDTO {
    private String schoolName;

    private String collegeName;

    private String userName;

    private String password;

    private String gender;
}
