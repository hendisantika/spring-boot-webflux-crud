package com.hendisantika.springbootwebfluxcrud.service;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
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
 * Time: 03:02
 * To change this template use File | Settings | File Templates.
 */
public interface ArticleService {

    Mono<Article> saveArticle(Article article);

    Flux<Article> findAllArticles();

    Mono<Article> findOneArticle(UUID id);

    Flux<Article> findByAuthor(String author);

    Mono<Void> deleteArticle(UUID id);
}
