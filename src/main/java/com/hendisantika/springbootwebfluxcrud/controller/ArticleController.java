package com.hendisantika.springbootwebfluxcrud.controller;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
import com.hendisantika.springbootwebfluxcrud.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/29/23
 * Time: 03:05
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/findAll")
    public Flux<Article> getAllArticles() {
        return articleService.findAllArticles();
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<Article>> createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article)
                .map(savedArticle -> new ResponseEntity<>(savedArticle, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Article>> getArticleById(@PathVariable Integer articleId) {
        return articleService.findOneArticle(articleId)
                .map(article -> ResponseEntity.ok(article))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
