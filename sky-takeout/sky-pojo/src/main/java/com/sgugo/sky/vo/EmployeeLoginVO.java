package com.sgugo.sky.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "员工登录的VO")
@AllArgsConstructor
public class EmployeeLoginVO implements Serializable {
    private long id;

    private String userName;

    private String name;

    private String token;
}
