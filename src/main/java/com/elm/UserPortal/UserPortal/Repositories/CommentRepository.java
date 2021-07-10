package com.elm.UserPortal.UserPortal.Repositories;

import com.elm.UserPortal.UserPortal.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO COMMENTS(TEXT, CREATED_AT, ARTICLEID, USER) VALUES(:text, :createdAt, :articleID, :user)", nativeQuery = true)
    void save(String text, LocalDateTime createdAt, int articleID, String user);

    @Query(value = "SELECT * FROM COMMENTS c WHERE c.ARTICLEID = ?1", nativeQuery = true)
    List<Comment> findAllCommentsByArticleID(int articleID);
}
