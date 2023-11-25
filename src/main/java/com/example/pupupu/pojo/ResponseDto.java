package com.example.pupupu.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
@Data
public class ResponseDto {
    String value;
    Boolean status;
    String task;
}
