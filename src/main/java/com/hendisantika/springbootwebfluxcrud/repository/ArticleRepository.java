package com.hendisantika.springbootwebfluxcrud.repository;

import com.hendisantika.springbootwebfluxcrud.entity.Article;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

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
@Repository
public interface ArticleRepository extends ReactiveMongoRepository<Article, Integer> {

    @Query("{'author': ?0}")
    Flux<Article> findByAuthor(String author);
}
