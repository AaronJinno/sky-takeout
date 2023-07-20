package com.sgugo.skypojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "员工登录的VO")
public class EmployeeLoginVO implements Serializable {
    private long id;

    private String userName;

    private String name;

    private String token;
}
