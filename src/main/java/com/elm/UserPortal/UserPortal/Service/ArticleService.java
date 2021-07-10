package com.elm.UserPortal.UserPortal.Service;

import com.elm.UserPortal.UserPortal.DTOS.ArticleDTO;
import com.elm.UserPortal.UserPortal.Models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article, String author);
    public ArticleDTO findArticle(int articleID);
    public Page<Article> findArticles(PageRequest pageRequest);
    public void deleteArticle(int articleID, String author);
    public void putLike(int articleID);
    public void putDislike(int articleID);
    public void disableArticle(int articleID);
    public void enableArticle(int articleID);
}
