package com.crledu.auto.web.response;

import java.io.Serializable;

/**
 * @Author: Trevor
 * @Date: 2020/6/29 14:00
 * @Description:
 */
public class Response<T> implements Serializable {
    private Response.Meta meta;
    private T data;

    public Response() {
    }

    public Response(ResponseState state) {
        this.meta = new Response.Meta(state);
    }

    public Response(String code, String message) {
        this.meta = new Response.Meta(code, message);
    }

    public Response(ResponseState state, String message) {
        this.meta = new Response.Meta(state, message);
    }

    public Response success() {
        this.meta = new Response.Meta(ResponseState.SUCCESS);
        return this;
    }

    public Response success(T data) {
        this.success();
        this.data = data;
        return this;
    }

    public Response message(String message) {
        this.getMeta().setMessage(message);
        return this;
    }

    public Response data(T data) {
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Response.Meta(ResponseState.FAIL);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Response.Meta(ResponseState.FAIL, message);
        return this;
    }

    public Response failure(String code,String message) {
        this.meta = new Response.Meta(ResponseState.FAIL, message);
        return this;
    }

    public Response unloginFailure(String message) {
        this.meta = new Response.Meta(ResponseState.UNLOGIN, message);
        return this;
    }

    public Response noResourceFailure(String message) {
        this.meta = new Response.Meta(ResponseState.NO_RESOURCE, message);
        return this;
    }

    public Response MeetingSignFailure(T data, String message) {
        this.meta = new Response.Meta(ResponseState.PARAM_ERROR, message);
        this.data = data;
        return this;
    }

    public Response failure(T data, String message) {
        this.failure(message);
        this.data = data;
        return this;
    }

    public Response.Meta getMeta() {
        return this.meta;
    }

    public T getData() {
        return this.data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }

    public static class Meta implements Serializable {
        private String code;
        private String message;

        public Meta() {
        }

        public Meta(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public Meta(ResponseState responseState) {
            this.setCode(responseState.getCode());
            this.message = responseState.getCodeInfo();
        }

        public Meta(ResponseState responseState, String message) {
            if (message == null) {
                message = responseState.getCodeInfo();
            }

            this.code = responseState.getCode();
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setCode(ResponseState state) {
            this.code = state.getCode();
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
