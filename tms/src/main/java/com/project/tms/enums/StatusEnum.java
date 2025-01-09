package com.project.tms.enums;

public enum StatusEnum {

    SUCCESS("0", "success"),
    FAILED("1", "failed");

    public final String code;
    public final String status;

    private StatusEnum(String code, String status){
        this.code = code;
        this.status = status;
    }
}
