package com.digitalhouse.obtenerdiploma.exceptions;
public class StandardError {

    private Integer status;
    private String message;
    private Long timeStamp;
    private String path;

    public StandardError(Integer status, String message, Long timeStamp, String path) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}