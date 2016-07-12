package com.spring.es.dao;

import com.spring.es.models.Article;

/**
 * @author huangd7
 */
public class CreateArticleResponse extends BaseResponse {

    private String id;

    public CreateArticleResponse(Article article) {
        this.id = article.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
