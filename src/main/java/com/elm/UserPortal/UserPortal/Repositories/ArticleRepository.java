package com.elm.UserPortal.UserPortal.Repositories;

import com.elm.UserPortal.UserPortal.DTOS.ArticleDTO;
import com.elm.UserPortal.UserPortal.Models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT * FROM ARTICLES a WHERE a.DISABLED = FALSE AND a.ARTICLEID = ?1", nativeQuery = true)
    Article findArticleByID(int articleID);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ARTICLES(TITLE, BODY, AUTHOR, NUMBER_OF_LIKES, NUMBER_OF_DISLIKES, DISABLED, CREATED_AT) VALUES(:title, :body, :author, :numOfLikes, :numOfDis, :disabled, :createdAt)", nativeQuery = true)
    void save(String title, String body, String author, int numOfLikes, int numOfDis, boolean disabled, LocalDateTime createdAt);

    @Query(value = "SELECT * FROM ARTICLES a WHERE a.DISABLED = FALSE", countQuery = "SELECT COUNT(*) FROM ARTICLES a WHERE a.DISABLED = FALSE", nativeQuery = true)
    Page<Article> findAllPaged(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ARTICLES a WHERE a.ARTICLEID = ?1 AND a.AUTHOR = ?2", nativeQuery = true)
    void deleteByIdAndAuthor(int articleID, String author);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICLES a SET a.NUMBER_OF_LIKES = a.NUMBER_OF_LIKES + 1 WHERE a.ARTICLEID = :articleID", nativeQuery = true)
    void like(int articleID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICLES a SET a.NUMBER_OF_DISLIKES = a.NUMBER_OF_DISLIKES + 1 WHERE a.ARTICLEID = :articleID", nativeQuery = true)
    void dislike(int articleID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICLES a SET DISABLED = 1 WHERE a.ARTICLEID = :articleID", nativeQuery = true)
    void disable(int articleID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICLES a SET DISABLED = 0 WHERE a.ARTICLEID = :articleID", nativeQuery = true)
    void enable(int articleID);
}
