package com.github.guokaia.mekatok.gateway.exception;

import cn.hutool.core.bean.BeanUtil;
import com.github.guokaia.mekatok.common.foreign.GeneralForeign;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

/**
 * 配置网关的异常处理
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/4
 */
public class GatewayErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    public GatewayErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                           ResourceProperties resourceProperties,
                                           ErrorProperties errorProperties,
                                           ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    /**
     * 构建返回数据的map
     */
    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        GeneralForeign<?> foreign = GeneralForeign.of(new GateWayException(), HttpStatus.UNAUTHORIZED);
        return BeanUtil.beanToMap(foreign);
    }

    /**
     * 根据 map 设置 http响应码
     */
    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        return super.getHttpStatus(errorAttributes);
    }
}
