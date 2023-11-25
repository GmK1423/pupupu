package com.example.pupupu.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
@Data
public class UserDto {
    String email;
    String password;
    String group;
}
