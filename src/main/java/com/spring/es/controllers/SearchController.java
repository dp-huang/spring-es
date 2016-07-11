package com.spring.es.controllers;

import com.spring.es.dao.CreateArticleRequest;
import com.spring.es.dao.CreateArticleResponse;
import com.spring.es.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangd7
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "search service";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(String keyword, Pageable pageable) {
        return searchService.search(keyword, pageable);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public CreateArticleResponse createDocument(@RequestBody CreateArticleRequest request) {
        return searchService.createDocument(request);
    }
}
