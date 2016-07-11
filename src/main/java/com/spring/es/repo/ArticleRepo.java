package com.spring.es.repo;

import com.spring.es.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huangd7
 */
@Repository
public interface ArticleRepo extends ElasticsearchRepository<Article, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
    Page<Article> findByTitle(String title, Pageable pageable);

}
