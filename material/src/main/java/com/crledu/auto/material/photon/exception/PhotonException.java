package com.crledu.auto.material.photon.exception;

import com.crledu.auto.web.exception.UserErrorCodeEnum;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:34
 * @Description: 异常类
 */
public class PhotonException extends RuntimeException {

    private UserErrorCodeEnum userErrorCodeEnum;

    private String errorDetail;
}
