package com.firstHelp.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllArticles {
    private int totalArticles;
    private List<Article> articles;

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
