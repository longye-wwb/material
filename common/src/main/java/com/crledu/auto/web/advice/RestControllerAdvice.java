package com.crledu.auto.web.advice;

import com.crledu.auto.web.exception.RestErrorException;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.crledu.auto.web.response.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 ************************************************************
 * @Description:  控制接口返回样式的统一，同时定义统一的业务
 * 错误返回编码。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 15:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ControllerAdvice
public class RestControllerAdvice {

    /**
     *****************************************************************************
     * @Description 处理系统定义普通异常
     *****************************************************************************
     * @Param [e]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 16:16
     *****************************************************************************
     **/
    @ExceptionHandler(RestErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response customException(RestErrorException e) {
        return new Response(e.getCode(),e.getMessage());
    }

    /**
     *****************************************************************************
     * @Description 处理系统定义的回滚异常
     *****************************************************************************
     * @Param [e]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 16:17
     *****************************************************************************
     **/
    @ExceptionHandler(RestRuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response customException(RestRuntimeException e) {
        return new Response(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new Response("10000002","请求方式不支持："+e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for(ObjectError oe:bindingResult.getAllErrors()){
            sb.append("参数（");
            DefaultMessageSourceResolvable defaultMessageSourceResolvable = (DefaultMessageSourceResolvable) oe.getArguments()[0];
            sb.append(defaultMessageSourceResolvable.getDefaultMessage()+")验证未通过，原因：");
            sb.append(oe.getDefaultMessage()+";");
        }
        return new Response("10000002","接口参数验证未通过。"+sb.toString());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleNotHandleException(NoHandlerFoundException e){
        return new Response("10000001","未找到对应的接口。");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return new Response("10000002","必要参数缺失"+e.getMessage());
    }

    /**
     *****************************************************************************
     * @Description 处理所有未处理的异常
     *****************************************************************************
     * @Param [e]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/29 21:00
     *****************************************************************************
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(Exception e){
        e.printStackTrace();
        return new Response("10000000","未处理的未定义异常。"+e.getMessage());
    }


}
