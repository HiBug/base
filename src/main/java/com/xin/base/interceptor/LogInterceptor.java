package com.xin.base.interceptor;

import com.alibaba.fastjson.JSON;
import com.xin.base.common.CommonErrorEnum;
import com.xin.base.core.BaseRequest;
import com.xin.base.core.BaseResponse;
import com.xin.base.core.BizException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2018/12/27 14:29
 * <p>
 *
 * </p>
 */
@Component
@Aspect
@Log4j2
public class LogInterceptor {

    @Pointcut("execution(* *.route(..))")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public BaseResponse log(ProceedingJoinPoint proceedingJoinPoint) {

        BaseRequest  request = (BaseRequest) proceedingJoinPoint.getArgs()[0];
        BaseResponse response;
        try {
            response = (BaseResponse) proceedingJoinPoint.proceed();
        } catch (BizException be) {
            response = be.buildResponse();
        } catch (Throwable t) {
            log.error("error:", t);
            response = CommonErrorEnum.error.buildResponse();
        }
        log.info("request:{},response:{}", JSON.toJSONString(request), JSON.toJSONString(response));
        return response;
    }
}
