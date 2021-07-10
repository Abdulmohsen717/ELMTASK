package com.elm.UserPortal.UserPortal.Service;

import com.elm.UserPortal.UserPortal.Models.Comment;
import com.elm.UserPortal.UserPortal.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void addComment(Comment comment, int articleID, String user) {
        commentRepository.save(comment.getText(), LocalDateTime.now(), articleID, user);
    }

    @Override
    public List<Comment> getArticleComments(int articleID) {
        return commentRepository.findAllCommentsByArticleID(articleID);
    }
}
