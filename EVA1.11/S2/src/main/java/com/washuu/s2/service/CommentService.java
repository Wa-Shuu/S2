package com.washuu.s2.service;

import com.washuu.s2.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByMid(Integer mid);
//    Integer getCommentNumber(Integer mid);
}
