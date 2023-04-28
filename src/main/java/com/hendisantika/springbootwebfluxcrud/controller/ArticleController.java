package com.hendisantika.springbootwebfluxcrud.controller;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
import com.hendisantika.springbootwebfluxcrud.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

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
    public Mono<ResponseEntity<Article>> getArticleById(@PathVariable UUID articleId) {
        return articleService.findOneArticle(articleId)
                .map(article -> ResponseEntity.ok(article))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{author}")
    public Flux<ResponseEntity<Article>> getArticleByAuthor(@PathVariable String author) {
        return articleService.findByAuthor(author)
                .map(article -> ResponseEntity.ok(article))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Article>> updateArticle(@PathVariable UUID articleId,
                                                       @RequestBody Article article) {
        return articleService.findOneArticle(articleId)
                .flatMap(existingArticle -> {
                    existingArticle.setTitle(article.getTitle());
                    existingArticle.setContent(article.getContent());
                    existingArticle.setAuthor(article.getAuthor());
                    existingArticle.setPublishedAt(article.getPublishedAt());
                    return articleService.saveArticle(existingArticle);
                })
                .map(updatedArticle -> new ResponseEntity<>(updatedArticle, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteArticle(@PathVariable UUID articleId) {
        return articleService.deleteArticle(articleId)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .onErrorResume(error -> Mono.just(new ResponseEntity<Void>(HttpStatus.NOT_FOUND)));
    }
}
