package com.spring.es.services;

import com.spring.es.dao.CreateArticleRequest;
import com.spring.es.dao.CreateArticleResponse;
import org.springframework.data.domain.Pageable;

/**
 * @author huangd7
 */
public interface SearchService {

    String search(String keyword, Pageable pageable);

    CreateArticleResponse createDocument(CreateArticleRequest request);
}
