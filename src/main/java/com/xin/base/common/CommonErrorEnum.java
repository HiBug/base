package com.xin.base.common;

import com.xin.base.core.BaseResponse;
import com.xin.base.core.BizException;
import com.xin.base.core.ResponseBean;
import lombok.Getter;

/**
 * @author three
 * @since 2019/1/8 11:45
 * <p>
 *
 * </p>
 */
@Getter
public enum CommonErrorEnum {

    success("0000", "ok"),

    param_error("9001", "参数校验失败"),
    error("9999", "error");

    private String code;
    private String msg;

    CommonErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void throwException() throws BizException {
        BizException exception = new BizException();
        exception.setCode(this.getCode());
        exception.setMsg(this.getMsg());
        throw exception;
    }

    public BaseResponse buildResponse() {
        BaseResponse response = new BaseResponse();
        response.setMsg(this.getMsg());
        response.setCode(this.getCode());
        return response;
    }

    public <T extends ResponseBean> BaseResponse<T> buildResponse(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        response.setCode(this.getCode());
        response.setMsg(this.getMsg());
        return response;
    }
}
