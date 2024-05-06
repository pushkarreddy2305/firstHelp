package com.firstHelp.demo.controllers;

import com.firstHelp.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.firstHelp.demo.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = newsService.getAllArticles();
        if (articles != null && !articles.isEmpty()) {
            return ResponseEntity.ok(articles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Article>> getNews(@RequestParam(value = "keyword") String keyword) {
        List<Article> articles = newsService.getArticles(keyword);
        if (articles != null && !articles.isEmpty()) {
            return ResponseEntity.ok(articles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Article> getArticleByTitle(@PathVariable("title") String title) {
        Article article = newsService.findArticleByTitle(title);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Article>> getArticlesByAuthor(@PathVariable("author") String author) {
        List<Article> articles = newsService.findArticlesByAuthor(author);
        if (articles != null && !articles.isEmpty()) {
            return ResponseEntity.ok(articles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

