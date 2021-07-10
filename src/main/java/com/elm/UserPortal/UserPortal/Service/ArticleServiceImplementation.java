package com.elm.UserPortal.UserPortal.Service;

import com.elm.UserPortal.UserPortal.DTOS.ArticleDTO;
import com.elm.UserPortal.UserPortal.DTOS.ObjectMapperUtils;
import com.elm.UserPortal.UserPortal.Models.Article;
import com.elm.UserPortal.UserPortal.Repositories.ArticleRepository;
import org.springframework.data.domain.PageRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImplementation implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addArticle(Article article, String author) {
        articleRepository.save(article.getTitle(), article.getBody(), author, article.getNumberOfLikes(), article.getNumberOfDislikes(), article.isDisabled(), LocalDateTime.now());
    }

    @Override
    public ArticleDTO findArticle(int articleID) {
        Article article = articleRepository.findArticleByID(articleID);
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        return articleDTO;
    }

    @Override
    public Page<Article> findArticles(PageRequest pageRequest) {
        Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
        return articleRepository.findAllPaged(pageRequest);
    }

    @Override
    public void deleteArticle(int articleID, String author) {
        articleRepository.deleteByIdAndAuthor(articleID, author);
    }

    @Override
    public void putLike(int articleID) {
        articleRepository.like(articleID);
    }

    @Override
    public void putDislike(int articleID) {
        articleRepository.dislike(articleID);
    }

    @Override
    public void disableArticle(int articleID) {
        articleRepository.disable(articleID);
    }

    @Override
    public void enableArticle(int articleID) {
        articleRepository.enable(articleID);
    }
}
