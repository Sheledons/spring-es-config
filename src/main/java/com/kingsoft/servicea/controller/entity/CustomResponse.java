package com.kingsoft.servicea.controller.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Sheledon
 * @date 2022/4/11
 */
@Builder
@Data
public class CustomResponse{
    private String messsage;
    private Integer code;
    private Object data;
}
