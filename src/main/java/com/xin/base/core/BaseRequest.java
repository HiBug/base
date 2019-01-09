package com.xin.base.core;

import com.xin.base.common.Function;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author three
 * @since 2018/12/26 23:26
 * <p>
 *
 * </p>
 */
@Data
public class BaseRequest {
    private Function function;
    @NotBlank(message = "openId can not be null")
    private String   openId;
    private Object   param;
}
