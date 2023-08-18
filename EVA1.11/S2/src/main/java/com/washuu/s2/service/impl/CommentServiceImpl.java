package com.washuu.s2.service.impl;

import com.washuu.s2.domain.Comment;
import com.washuu.s2.domain.CommentExample;
import com.washuu.s2.mapper.CommentMapper;
import com.washuu.s2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public List<Comment> getCommentByMid(Integer mid) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andMidEqualTo(mid);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
//        if(comments.isEmpty()) {
//            Comment comment = new Comment();
//            comments.add(comment);
//        }
        return comments;
    }

}
