package com.xin.base.core;

/**
 * @author three
 * @since 2018/12/26 23:46
 * <p>
 *
 * </p>
 */
public interface Handler<T extends RequestBean> {
    BaseResponse handle(T request, String openId) throws BizException;
}
