package com.washuu.s2.util.Enum;

public class Result<T> {
    private String value;
    private T msg;

    public Result() {
        super();
    }

    public Result(String value, T msg) {
        this.value = value;
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                ", value='" + value + '\'' +
                ", msg=" + msg +
                '}';
    }
}