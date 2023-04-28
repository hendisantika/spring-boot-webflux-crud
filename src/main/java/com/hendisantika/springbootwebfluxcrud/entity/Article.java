package com.hendisantika.springbootwebfluxcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/29/23
 * Time: 03:01
 * To change this template use File | Settings | File Templates.
 */
@Document(collection = "articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private Integer id;
    private String title;
    private String content;
    private String author;
    private Date publishedAt;
}
