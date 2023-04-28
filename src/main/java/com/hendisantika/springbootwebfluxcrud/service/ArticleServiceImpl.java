package com.hendisantika.springbootwebfluxcrud.service;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
import com.hendisantika.springbootwebfluxcrud.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/29/23
 * Time: 03:03
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Mono<Article> saveArticle(Article article) {

        return articleRepository.save(article);

        //for Mono<String> return type
        //return Mono.just("saved successfully");
    }

    @Override
    public Flux<Article> findAllArticles() {
        return articleRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Article> findOneArticle(Integer id) {
        return articleRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Article> findByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }
}
