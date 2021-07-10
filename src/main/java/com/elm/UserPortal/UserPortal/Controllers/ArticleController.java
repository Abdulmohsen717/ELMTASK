package com.elm.UserPortal.UserPortal.Controllers;

import com.elm.UserPortal.UserPortal.DTOS.ArticleDTO;
import com.elm.UserPortal.UserPortal.Models.Article;
import com.elm.UserPortal.UserPortal.Models.Comment;
import com.elm.UserPortal.UserPortal.Service.ArticleService;
import com.elm.UserPortal.UserPortal.Service.CommentService;
import org.hibernate.procedure.internal.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@ControllerAdvice
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    //@PreAuthorize("hasAnyAuthority('USER')")
    @RequestMapping(value = "/article/{author}", method = RequestMethod.POST)
    public ResponseEntity addArticle(@RequestBody Article article, @PathVariable("author") String author) {
        articleService.addArticle(article, author);
        return ResponseEntity.ok(article);
    }

    @GetMapping(value = "/article/{id}")
    public ResponseEntity getArticle(@PathVariable("id") int articleID) {
        ArticleDTO articleDTO = articleService.findArticle(articleID);
        return ResponseEntity.ok(articleDTO);
    }

    @GetMapping(value = "/article")
    public ResponseEntity getArticles(@RequestParam int pageNumber, @RequestParam int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(articleService.findArticles(pageRequest));
    }


    @RequestMapping(value = "/article/{id}/{author}", method = RequestMethod.DELETE)
    public ResponseEntity deleteArticle(@PathVariable("id") int articleID, @PathVariable("author") String author) {
        articleService.deleteArticle(articleID, author);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}/comment/{user}", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment, @PathVariable("id") int articleID, @PathVariable("user") String user) {
        commentService.addComment(comment, articleID, user);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(value = "/article/{id}/comment")
    public ResponseEntity getArticleComments(@PathVariable("id") int articleID) {
        return ResponseEntity.ok(commentService.getArticleComments(articleID));
    }

    @RequestMapping(value = "/article/{id}/like", method = RequestMethod.PUT)
    public ResponseEntity addLike(@PathVariable("id") int articleID) {
        articleService.putLike(articleID);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}/dislike", method = RequestMethod.PUT)
    public ResponseEntity addDislike(@PathVariable("id") int articleID) {
        articleService.putDislike(articleID);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}/disable", method = RequestMethod.PUT)
    public ResponseEntity makeArticleDisabled(@PathVariable("id") int articleID) {
        articleService.disableArticle(articleID);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}/enable", method = RequestMethod.PUT)
    public ResponseEntity makeArticleEnabled(@PathVariable("id") int articleID) {
        articleService.enableArticle(articleID);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
