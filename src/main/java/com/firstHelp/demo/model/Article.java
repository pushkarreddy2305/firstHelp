package com.firstHelp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
    private String title;
    private String description;
    private String content;
    private String url;
    private String image;
    @JsonProperty("publishedAt")
    private String publishedDate;
    private NewsSource source;

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public NewsSource getSource() {
        return source;
    }

    public void setSource(NewsSource source) {
        this.source = source;
    }
}

