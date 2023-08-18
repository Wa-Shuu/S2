package com.washuu.s2.domain;

public class Topic {
    private Integer tid;

    private Integer mid;

    private String content;

    private String createTime;

    private Integer commend;

    private Integer unlike;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCommend() {
        return commend;
    }

    public void setCommend(Integer commend) {
        this.commend = commend;
    }

    public Integer getUnlike() {
        return unlike;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }
}