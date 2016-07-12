package com.spring.es.controllers;

import com.spring.es.dto.CreateArticleRequest;
import com.spring.es.dto.CreateArticleResponse;
import com.spring.es.dto.SearchArticleResponse;
import com.spring.es.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public SearchArticleResponse search(@RequestParam("keyword") String keyword, Pageable pageable) {
        return searchService.search(keyword, pageable);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public CreateArticleResponse createDocument(@RequestBody CreateArticleRequest request) {
        return searchService.createDocument(request);
    }
}
