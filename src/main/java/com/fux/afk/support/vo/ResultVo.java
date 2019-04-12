package com.fux.afk.support.vo;

import java.util.HashMap;

/**
 * Created by fuxiaoj on 2018/12/20 0020.
 */
public final class ResultVo {

    private boolean success;
    private String code;
    private String message;
    protected HashMap<String, Object> data;

    public ResultVo() {
        data = new HashMap<>();
    }

    public ResultVo(boolean success, String code, String message) {
        this();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static ResultVo successInfo() {
        return successInfo(null, null);
    }

    public static ResultVo successInfo(String code, String message) {
        return new ResultVo(true, code, message);
    }

    public static ResultVo successInfo(String message) {
        return new ResultVo(true, "success", message);
    }

    public static ResultVo failedInfo() {
        return failedInfo(null, null);
    }

    public static ResultVo failedInfo(String message) {
        return new ResultVo(false, "error", message);
    }

    public static ResultVo failedInfo(String code, String message) {
        return new ResultVo(false, code, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public ResultVo putData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
