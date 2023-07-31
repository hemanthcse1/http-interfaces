package com.hemanth.newcontentservice.controller;

import com.hemanth.newcontentservice.model.Article;
import com.hemanth.newcontentservice.service.ArticleClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ArticleClient articleClient;

    public ContentController(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    @GetMapping("/articles")
    public List<Article> findAllArticles(){
        return articleClient.findAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> findById(@PathVariable Integer id) {
        return articleClient.findOne(id);
    }

    @PostMapping("/articles")
    public void create(@RequestBody Article article) {
        articleClient.create(article);
    }

    @PutMapping("/articles/{id}")
    public void update(@RequestBody Article article, @PathVariable Integer id) {
        articleClient.update(article,id);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable Integer id) {
        articleClient.delete(id);
    }
}
