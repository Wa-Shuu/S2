package com.washuu.s2.domain;

public class Comment {
    private Integer comId;

    private Integer mid;

    private String content;

    private String momentType;

    private Integer toUid;

    private Integer fromUid;

    private Integer commend;

    private Integer unlike;

    private String createTime;

    private String updateTime;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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

    public String getMomentType() {
        return momentType;
    }

    public void setMomentType(String momentType) {
        this.momentType = momentType;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}