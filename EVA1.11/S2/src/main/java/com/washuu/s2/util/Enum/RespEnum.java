package com.washuu.s2.util.Enum;

public enum RespEnum {
    STATE("state"),
    MESSAGE("message"),
    TOKEN("token"),
    OK("true"),
    SUCCESS("true"),
    FAILED("false"),
    ERROR("false"),
    FORBIDDEN("false"),
    FALSE("false"),
    PASS("true")
    ;

    private final String value;
    RespEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
