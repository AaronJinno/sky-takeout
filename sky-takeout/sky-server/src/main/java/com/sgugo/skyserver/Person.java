package com.sgugo.skyserver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name="Person：用户类",description = "定义用户的类")
public class Person {
    @Schema(description = "用户的性名",defaultValue = "Jinno",required=true)
    private String username;
    private int age;
    private Date birthday;
}
