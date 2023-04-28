package com.hendisantika.springbootwebfluxcrud.controller;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
import com.hendisantika.springbootwebfluxcrud.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
