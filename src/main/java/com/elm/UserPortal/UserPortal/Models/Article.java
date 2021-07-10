package com.elm.UserPortal.UserPortal.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticleID", nullable = false)
    private int articleID;


    @Column(name = "Title", nullable = false, length = 100)
    private String title;

    @Column(name = "Body", nullable = false, length = 500)
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Author", nullable = false)
    @JsonIgnore
    private User author;

    @Column(name = "CreatedAt", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    /*@Lob
    @Column(name = "Image")
    private byte[] image;*/

    @Column(name = "NumberOfLikes", nullable = false)
    private int numberOfLikes;

    @Column(name = "NumberOfDislikes", nullable = false)
    private int numberOfDislikes;

    @Column(name = "Disabled", nullable = false)
    private boolean disabled;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Article() {

    }

    public Article(int articleID, String title, String body, User author, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, boolean disabled, List<Comment> comments) {
        this.articleID = articleID;
        this.title = title;
        this.body = body;
        this.author = author;
        this.createdAt = createdAt;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.disabled = disabled;
        this.comments = comments;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
