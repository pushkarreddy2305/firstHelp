package com.firstHelp.demo.service;

import com.firstHelp.demo.model.Article;
import com.firstHelp.demo.model.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Value("${gnews.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("articlesByKeyword")
    public List<Article> getArticles(String keyword) {
        String url = baseUrl + "/search?q=" + keyword + "&token=6eddc9b2c94a53aad1486bfcd13c9ee8"; // Replace YOUR_API_TOKEN with your actual API token
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
        if (response != null) {
            return response.getArticles();
        }
        return null;
    }

    @Cacheable("articleByTitle")
    public Article findArticleByTitle(String title) {
        String url = baseUrl + "/search?q=" + title + "&token=6eddc9b2c94a53aad1486bfcd13c9ee8"; // Replace YOUR_API_TOKEN with your actual API token
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
        if (response != null && !response.getArticles().isEmpty()) {
            return response.getArticles().get(0);
        }
        return null;
    }

    @Cacheable("articlesByAuthor")
    public List<Article> findArticlesByAuthor(String author) {
        String url = baseUrl + "/search?q=" + author + "&token=6eddc9b2c94a53aad1486bfcd13c9ee8"; // Replace YOUR_API_TOKEN with your actual API token
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
        if (response != null) {
            return response.getArticles();
        }
        return null;
    }

    @Cacheable("allArticles")
    public List<Article> getAllArticles() {
        List<Article> allArticles = new ArrayList<>();
        int currentPage = 1;

        // Fetch articles until all pages are retrieved
        while (true) {
            String url = baseUrl + "/search?q=example&token=6eddc9b2c94a53aad1486bfcd13c9ee8&page=" + currentPage; // Replace YOUR_API_TOKEN with your actual API token
            NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
            if (response != null && response.getArticles() != null && !response.getArticles().isEmpty()) {
                allArticles.addAll(response.getArticles());
                currentPage++;
            } else {
                break; // No more articles available
            }
        }
        return allArticles;
    }
}

