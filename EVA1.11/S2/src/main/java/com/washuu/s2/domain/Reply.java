package com.washuu.s2.domain;

public class Reply {
    private Integer rid;

    private Integer commentId;

    private Integer replyId;

    private Integer toUid;

    private Integer fromUid;

    private String content;

    private Integer unlike;

    private Integer commend;

    private String createTime;

    private String replyType;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUnlike() {
        return unlike;
    }

    public void setUnlike(Integer unlike) {
        this.unlike = unlike;
    }

    public Integer getCommend() {
        return commend;
    }

    public void setCommend(Integer commend) {
        this.commend = commend;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType;
    }
}