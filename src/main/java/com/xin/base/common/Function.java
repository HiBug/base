package com.xin.base.common;

import com.xin.base.core.RequestBean;

/**
 * @author three
 * @since 2019/1/8 11:35
 * <p>
 *
 * </p>
 */
public interface Function extends EnumBase {
    Class<? extends RequestBean> getRequestBeanClass();
}
