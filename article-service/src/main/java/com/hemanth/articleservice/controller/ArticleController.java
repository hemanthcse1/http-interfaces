package com.hemanth.articleservice.controller;

import com.hemanth.articleservice.model.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final List<Article> articles = new ArrayList<>();


    @GetMapping
    public List<Article> findAll(){
        return articles;
    }

    @GetMapping("/{id}")
    public Optional<Article> findById(@PathVariable Integer id){
        return articles.stream()
                .filter(article -> article.id()==id)
                .findFirst();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Article article){
        articles.add(article);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Article article, @PathVariable Integer id){
        Optional<Article> existingArticle = articles.stream().filter(article1 -> article1.id().equals(id)).findFirst();
        existingArticle.ifPresent(value -> articles.set(articles.indexOf(value),article));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        articles.removeIf(article -> article.id().equals(id));
    }

    @PostConstruct
    private void init(){

        articles.add(new Article(1,"Hello World","This is my first blog post"));

    }
}
