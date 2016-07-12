package com.spring.es.services;

import com.spring.es.dto.CreateArticleRequest;
import com.spring.es.dto.CreateArticleResponse;
import com.spring.es.dto.SearchArticleResponse;
import com.spring.es.models.Article;
import com.spring.es.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author huangd7
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public SearchArticleResponse search(String keyword, Pageable pageable) {
        Page<Article> articles = articleRepo.findByTitle(keyword, pageable);
        return new SearchArticleResponse(articles);
    }

    @Override
    public CreateArticleResponse createDocument(CreateArticleRequest request) {
        Article article = new Article();
        article.setId(UUID.randomUUID().toString());
        article.setTitle(request.getTitle());
        article.setDescription(request.getDescription());

        Article saved = articleRepo.save(article);

        return new CreateArticleResponse(saved);
    }
}
