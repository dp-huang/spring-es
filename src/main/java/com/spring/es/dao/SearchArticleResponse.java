package com.spring.es.dao;

import com.spring.es.models.Article;
import org.springframework.data.domain.Page;

/**
 * @author huangd7
 */
public class SearchArticleResponse extends BaseResponse {

    private Page<Article> articles;

    public SearchArticleResponse(Page<Article> articles) {
        this.articles = articles;
    }

    public Page<Article> getArticles() {
        return articles;
    }

    public void setArticles(Page<Article> articles) {
        this.articles = articles;
    }
}
