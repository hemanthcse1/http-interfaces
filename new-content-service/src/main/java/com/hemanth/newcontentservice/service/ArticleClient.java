package com.hemanth.newcontentservice.service;

import com.hemanth.newcontentservice.model.Article;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.Optional;

public interface ArticleClient {

    @GetExchange("/articles")
    List<Article> findAll();

    @GetExchange("/articles/{id}")
    Optional<Article> findOne(@PathVariable Integer id);

    @PostExchange("/articles")
    void create(@RequestBody Article article);

    @PutMapping("/articles/{id}")
    void update(@RequestBody Article article, @PathVariable Integer id);

    @DeleteExchange("/articles/{id}")
    void delete(@PathVariable Integer id);



}
