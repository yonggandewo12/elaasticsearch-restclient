package com.elasticsearch.restclient.controller;


import com.elasticsearch.restclient.entity.Book;
import com.elasticsearch.restclient.service.ElasticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.tophits.ParsedTopHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/***
 * @author xuliang3
 * @date 2019/10/14 10:42
 **/
@RestController
@Api(value = "Service Controller|业务Controller")
@Slf4j
public class ServiceController {

    @Autowired
    private ElasticService elasticService;

    @PostMapping("/addBook")
    @ApiOperation(value = "添加元素", notes = "添加元素")
    public IndexResponse addTarget(@RequestBody Book book) {
        return elasticService.addBook(book);
    }

    @PostMapping("/getBook")
    @ApiOperation(value = "获取book", notes = "获取book,全词匹配，不分词")
    public SearchHits getBook(@RequestParam("书名") String name) {
        return elasticService.getBook(name);
    }

    @DeleteMapping("/deleteBook")
    @ApiOperation(value = "删除book", notes = "删除book")
    public DeleteResponse deleteBook(@RequestParam("书名") String name) {
        return elasticService.deleteBook(name);

    }

    @PostMapping("/updateBook")
    @ApiOperation(value = "更新book", notes = "更新book")
    public UpdateResponse updateBook(@RequestBody Book book) {
        return elasticService.updateBook(book);

    }


    @PostMapping("/aveAggreate")
    @ApiOperation(value = "Matrix聚合索引", notes = "Matrix聚合索引")
    public Max aveAggreate(@RequestParam("聚合索引关键字") String key) {
        return elasticService.averageAggregate(key);
    }

    @PostMapping("/topAggreate")
    @ApiOperation(value = "top聚合索引", notes = "top聚合索引")
    public ParsedTopHits topAggreate(@RequestParam("聚合索引关键字") String key) {
        return elasticService.topAggregate(key);
    }

    @PostMapping("/termsAggreate")
    @ApiOperation(value = "terms聚合索引", notes = "terms聚合索引")
    public ParsedLongTerms  termsAggreate(@RequestParam("聚合索引关键字") String key) {
        return elasticService.termsAggregate(key);
    }

    @PostMapping("/logTermsMultiAggregate")
    @ApiOperation(value = "日志多值聚合索引", notes = "日志多值聚合索引")
    public ParsedLongTerms  logTermsMultiAggregate(@RequestParam("聚合索引关键字") String key) {
        return elasticService.logTermsMultiAggregate(key);
    }


    @PostMapping("/filterAggregate")
    @ApiOperation(value = "filter聚合索引", notes = "filter聚合索引")
    public ParsedStringTerms filterAggregate(@RequestParam("包含") String include, @RequestParam("排除") String exclude, @RequestParam("聚合索引关键字") String field) {
        return elasticService.filterAggregate(include, exclude, field);
    }

    @PostMapping("/term")
    @ApiOperation(value = "term索引", notes = "term索引")
    public SearchResponse filterAggregate(@RequestParam("key") String key) {
        return elasticService.term(key);
    }



    @PostMapping("/boolWithMultiFilter")
    @ApiOperation(value = "boolWithMultiFilter索引", notes = "boolWithMultiFilter索引")
    public SearchHits boolWithMultiFilter(@RequestParam("包含的postDate") String postDate, @RequestParam("包含的articleId")String articleId, @RequestParam("过滤掉的postDate")String notKey) {
        return elasticService.boolWithMultiFilter(postDate, articleId, notKey);
    }


}
