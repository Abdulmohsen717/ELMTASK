package com.elm.UserPortal.UserPortal.DTOS;

import java.time.LocalDateTime;

public class ArticleDTO {
    private int articleID;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private int numberOfLikes;
    private int numberOfDislikes;
    private boolean disabled;

    public ArticleDTO() {

    }

    public ArticleDTO(int articleID, String title, String body, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, boolean disabled) {
        this.articleID = articleID;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.disabled = disabled;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
