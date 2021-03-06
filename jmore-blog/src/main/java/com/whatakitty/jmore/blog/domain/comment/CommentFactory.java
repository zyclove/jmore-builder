package com.whatakitty.jmore.blog.domain.comment;

import com.whatakitty.jmore.blog.domain.security.User;
import com.whatakitty.jmore.blog.domain.service.AggregateIdService;
import com.whatakitty.jmore.framework.ddd.publishedlanguage.AggregateId;
import java.util.Date;

/**
 * comment factory
 *
 * @author WhatAKitty
 * @date 2019/05/26
 * @description
 **/
public final class CommentFactory {

    public static final CommentFactory FACTORY = new CommentFactory();

    public Comment createComment(AggregateId<Long> commentId,
                                 CommentableResource commentableResource,
                                 User publisher,
                                 String commentContent) {
        // basic content
        final Comment comment = new Comment(commentId);
        comment.setContent(commentContent);
        comment.setCommentableResource(commentableResource);
        comment.setPublisher(publisher);
        comment.setCommentTime(new Date());
        return comment;
    }

}
