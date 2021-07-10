package com.elm.UserPortal.UserPortal.Service;

import com.elm.UserPortal.UserPortal.Models.Comment;

import java.util.List;


public interface CommentService {
    public void addComment(Comment comment, int articleID, String user);
    public List<Comment> getArticleComments(int articleID);
}
