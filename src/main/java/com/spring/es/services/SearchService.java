package com.spring.es.services;

import com.spring.es.dao.CreateArticleRequest;
import com.spring.es.dao.CreateArticleResponse;
import com.spring.es.dao.SearchArticleResponse;
import org.springframework.data.domain.Pageable;

/**
 * @author huangd7
 */
public interface SearchService {

    SearchArticleResponse search(String keyword, Pageable pageable);

    CreateArticleResponse createDocument(CreateArticleRequest request);
}
