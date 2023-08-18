package com.washuu.s2.util.Enum;

public enum TokenEnum {

    HEADER("header"),
    PAY_LOAD("payLoad"),
    SIGNATURE("signature"),
    USER_NAME("userName"),
    USER_ROLE("userRole"),
    PASSWORD("password");

    private String component;
    TokenEnum(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
