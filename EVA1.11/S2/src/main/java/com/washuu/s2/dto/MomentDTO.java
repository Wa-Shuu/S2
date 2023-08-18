package com.washuu.s2.dto;

import com.washuu.s2.domain.Comment;
import com.washuu.s2.domain.Moment;
import com.washuu.s2.domain.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MomentDTO {
    private Integer mid;
    private String content;
    private String topic;
    private String imageUrl;
    private String avatar;
    private String userName;
    private Integer commend;
    private Integer unlike;
    private Integer collectionNum;
    private Integer commentId;
    private String commentContent;
    private String createTime;
    private Double score;
    public MomentDTO(){};


    public MomentDTO (Moment moment, User user, Double score) {
        this.content = moment.getContent();
        this.topic = moment.getTopic();
        this.imageUrl = moment.getImages();
        this.commend = moment.getCommend();
        this.unlike = moment.getUnlike();
        this.collectionNum = moment.getCollectionNum();
        this.commentId = moment.getCommentId();
        this.mid = moment.getMid();
        this.userName = user.getUserName();
//        this.commentContent = comment.getContent();这里还是分开好哦，
//        一条指令专门查moment,另一条指令专门查moment对应的comment；其中通过mid关联起来
        this.avatar = user.getAvatar();
        this.createTime = moment.getCreateTime();
        this.score = score;

    }

}
